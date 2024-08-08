package com.youtube.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.youtube.jwt.dao.LeadDao;
import com.youtube.jwt.entity.Lead;

import java.util.List;
import java.util.Optional;

@Service
public class LeadService {
    @Autowired
    private LeadDao leadDao;

    public Long getLeadCount() {
        return leadDao.count();
    }
    public Lead saveLead(Lead lead) {
        return leadDao.save(lead);
    }
    public List<Lead> getAllLeads() {
        return leadDao.findAll();
    }
    public Optional<Lead> getLeadById(Long id) {
        return leadDao.findById(id);
    }
    public void deleteLead(Long id) {
    	leadDao.deleteById(id);
    }
    
    public Lead updateLeadContact(Long id, Lead updatedContact) {
    	Lead existingContact = leadDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lead contact not found"));

        existingContact.setSalutation(updatedContact.getSalutation());
        existingContact.setName(updatedContact.getName());
        existingContact.setEmail(updatedContact.getEmail());
        existingContact.setLeadSource(updatedContact.getLeadSource());
        existingContact.setAddedBy(updatedContact.getAddedBy());
        existingContact.setCompanyName(updatedContact.getCompanyName());
        existingContact.setWebsite(updatedContact.getWebsite());
        existingContact.setMobile(updatedContact.getMobile());
        existingContact.setOfficePhone(updatedContact.getOfficePhone());
        existingContact.setCountry(updatedContact.getCountry());
        existingContact.setState(updatedContact.getState());
        existingContact.setCity(updatedContact.getCity());
        existingContact.setPostalCode(updatedContact.getPostalCode());
        existingContact.setAddress(updatedContact.getAddress());
        existingContact.setSavedAt(updatedContact.getSavedAt());

        return leadDao.save(existingContact);
    }
}
