package com.youtube.jwt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.youtube.jwt.dao.ProposalProductRepository;
import com.youtube.jwt.dao.ProposalRepository;
import com.youtube.jwt.entity.Product;
import com.youtube.jwt.entity.Proposal;
import com.youtube.jwt.entity.ProposalProduct;
import com.youtube.jwt.service.ProposalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Base64;

@RestController
public class ProposalController {
	@Autowired
	private ProposalService proposalService;
	private static final Logger logger = LoggerFactory.getLogger(ProposalController.class);

	@PostMapping("/proposals")
	public Proposal handleProposal(@RequestBody Proposal proposal) {
		List<ProposalProduct> proposalProducts = proposal.getProposalProducts();

		// Ensure the proposal reference is set on each product
		for (ProposalProduct product : proposalProducts) {
			product.setProposal(proposal);
		}

		return proposalService.saveProposal(proposal);
	}

	@GetMapping("/proposals/{proposalId}")
	public ResponseEntity<Proposal> getProposalById(@PathVariable Long proposalId) {
		Proposal proposal = proposalService.getProposalById(proposalId);
		return ResponseEntity.ok(proposal);
	}
      

	@GetMapping("/proposals")
	public List<Proposal> getAllProducts() {
		return proposalService.getAllProjects();
	}
	
	 @PutMapping("/proposals/{proposalId}")
	    public ResponseEntity<Proposal> updateProposal(
	            @PathVariable Long proposalId,
	            @RequestBody Proposal updatedProposal) {
	        Proposal savedProposal = proposalService.updateProposal(proposalId, updatedProposal);
	        return ResponseEntity.ok(savedProposal);
	    }
	 
	 @DeleteMapping("/proposals/{proposalId}")
	    public ResponseEntity<Void> deleteProposal(@PathVariable Long proposalId) {
	        proposalService.deleteProposal(proposalId);
	        return ResponseEntity.noContent().build();
	    }

}
