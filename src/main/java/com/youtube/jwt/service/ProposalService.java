package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.DealsDao;
import com.youtube.jwt.dao.LeadDao;
import com.youtube.jwt.dao.ProposalProductRepository;
import com.youtube.jwt.dao.ProposalRepository;
import com.youtube.jwt.entity.Deals;
import com.youtube.jwt.entity.Employee;
import com.youtube.jwt.entity.Lead;
import com.youtube.jwt.entity.Project;
import com.youtube.jwt.entity.Proposal;
import com.youtube.jwt.entity.ProposalProduct;
import com.youtube.jwt.exception.EntityNotFoundException;

@Service
public class ProposalService {
	
	@Autowired
     private ProposalRepository proposalRepository;
	
	@Autowired
	private ProposalProductRepository proposalProductRepository;
	
	@Autowired
	private LeadDao leadDao;
	@Autowired
	private DealsDao dealsDao;
	
    @Transactional
    public Proposal saveProposal(Proposal proposal) {
    	Lead lead = leadDao.findById(proposal.getLeadId())
                .orElseThrow(() -> new RuntimeException("Lead not found"));
    	proposal.setLead(lead);
    	Deals deals = dealsDao.findById(proposal.getDealId())
                .orElseThrow(() -> new RuntimeException("Lead not found"));
    	proposal.setDeals(deals);
        Proposal savedProposal = proposalRepository.save(proposal);
         return savedProposal;
    }
    public List<Proposal> getAllProjects() {
        return proposalRepository.findAll();
    }
    public Proposal getProposalById(Long proposalId) {
        return proposalRepository.findById(proposalId)
                .orElseThrow(() -> new RuntimeException("Proposal not found"));
    }
    
    @Transactional
    public Proposal updateProposal(Long proposalId, Proposal updatedProposal) {
        Proposal existingProposal = proposalRepository.findById(proposalId)
                .orElseThrow(() -> new RuntimeException("Proposal not found"));

        if (updatedProposal.getDealId() != null) {
            Deals deals = dealsDao.findById(updatedProposal.getDealId())
                    .orElseThrow(() -> new RuntimeException("Deals not found"));
            existingProposal.setDeals(deals);
            existingProposal.setDealId(updatedProposal.getDealId());
        }
        
        if (updatedProposal.getLeadId() != null) {
            Lead lead = leadDao.findById(updatedProposal.getLeadId())
                    .orElseThrow(() -> new RuntimeException("Lead not found"));
            existingProposal.setLead(lead);
            existingProposal.setLeadId(updatedProposal.getLeadId());
        }
        
        if (updatedProposal.getValidTill() != null) {
            existingProposal.setValidTill(updatedProposal.getValidTill());
        }

        if (updatedProposal.getCurrency() != null) {
            existingProposal.setCurrency(updatedProposal.getCurrency());
        }

        if (updatedProposal.getCalculateTax() != null) {
            existingProposal.setCalculateTax(updatedProposal.getCalculateTax());
        }

        if (updatedProposal.getDescription() != null) {
            existingProposal.setDescription(updatedProposal.getDescription());
        }

        if (updatedProposal.getTotal() != null) {
            existingProposal.setTotal(updatedProposal.getTotal());
        }

        if (updatedProposal.getDate() != null) {
            existingProposal.setDate(updatedProposal.getDate());
        }

        if (updatedProposal.getRecipientNote() != null) {
            existingProposal.setRecipientNote(updatedProposal.getRecipientNote());
        }

        existingProposal.setSignatureApproval(updatedProposal.isSignatureApproval());

        if (updatedProposal.getProposalProducts() != null && !updatedProposal.getProposalProducts().isEmpty()) {
            existingProposal.getProposalProducts().clear();
            for (ProposalProduct proposalProduct : updatedProposal.getProposalProducts()) {
                existingProposal.addProposalProduct(proposalProduct);
            }
        }

        Proposal savedProposal = proposalRepository.save(existingProposal);
        return savedProposal;
    }
    
    @Transactional
    public void deleteProposal(Long proposalId) {
        Proposal proposal = proposalRepository.findById(proposalId)
                .orElseThrow(() -> new RuntimeException("Proposal not found"));
        proposalRepository.delete(proposal);
    }
}
