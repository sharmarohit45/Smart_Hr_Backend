package com.youtube.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.youtube.jwt.dao.ClientDao;
import com.youtube.jwt.entity.Client;
import com.youtube.jwt.entity.Employee;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class ClientService {

    @Autowired
    private ClientDao clientDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    public Long getClientCount() {
        return clientDao.count();
    }
    public Client saveClient(Client client) {
    	String encodedPassword = passwordEncoder.encode(client.getPassword());
    	client.setPassword(encodedPassword);
    	 if (client.getImageProfileData() != null && StringUtils.hasText(client.getImageProfile())) {
             String directoryPath = "src/images/ClientProfileImages";
             String imagePath = ImageFileHandler.saveImageDataToFile(directoryPath, client.getImageProfile(), client.getImageProfileData());
             if (imagePath != null) {
            	 client.setImageProfile(imagePath);
             } else {
                 // Handle the case where image saving fails
             }
         }
    	 if (client.getImageLogoData() != null && StringUtils.hasText(client.getImageLogo())) {
             String directoryPath = "src/images/ClientLogoImages"; // Set your image directory path here
             String imagePath = ImageFileHandler.saveImageDataToFile(directoryPath, client.getImageLogo(), client.getImageLogoData());
             if (imagePath != null) {
            	 client.setImageLogo(imagePath);
             } else {
                 // Handle the case where image saving fails
             }
         }
        return clientDao.save(client);
    }
    public List<Client> getAllClients() {
		List<Client> clients = new ArrayList<>();
		clientDao.findAll().forEach(clients::add);
		return clients;
	}
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
    public Optional<Client> getClientById(Long clientId) {
        Optional<Client> client = clientDao.findById(clientId);
        if (client.isEmpty()) {
            //Logger.warning("Employee with ID " + empId + " not found.");
        }
        return client;
    }
    @Transactional
    public Client updateClient(Long clientId, Client updatedClient) {
        Client existingClient = clientDao.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        if (updatedClient.getSalutation() != null) {
            existingClient.setSalutation(updatedClient.getSalutation());
        }
        if (updatedClient.getClientName() != null) {
            existingClient.setClientName(updatedClient.getClientName());
        }
        if (updatedClient.getEmail() != null) {
            existingClient.setEmail(updatedClient.getEmail());
        }
        if (updatedClient.getProfilePicture() != null) {
            existingClient.setProfilePicture(updatedClient.getProfilePicture());
        }
        if (updatedClient.getPassword() != null) {
            existingClient.setPassword(updatedClient.getPassword());
        }
        if (updatedClient.getCountry() != null) {
            existingClient.setCountry(updatedClient.getCountry());
        }
        if (updatedClient.getMobileNo() != null) {
            existingClient.setMobileNo(updatedClient.getMobileNo());
        }
        if (updatedClient.getGendar() != null) {
            existingClient.setGendar(updatedClient.getGendar());
        }
        if (updatedClient.getChangeLanguage() != null) {
            existingClient.setChangeLanguage(updatedClient.getChangeLanguage());
        }
        if (updatedClient.getClientCategory() != null) {
            existingClient.setClientCategory(updatedClient.getClientCategory());
        }
        if (updatedClient.getClientSubCategory() != null) {
            existingClient.setClientSubCategory(updatedClient.getClientSubCategory());
        }
        if (updatedClient.getLoginAllowed() != null) {
            existingClient.setLoginAllowed(updatedClient.getLoginAllowed());
        }
        if (updatedClient.getEmailNotificationAllowed() != null) {
            existingClient.setEmailNotificationAllowed(updatedClient.getEmailNotificationAllowed());
        }
        if (updatedClient.getCompanyName() != null) {
            existingClient.setCompanyName(updatedClient.getCompanyName());
        }
        if (updatedClient.getOfficialWebsite() != null) {
            existingClient.setOfficialWebsite(updatedClient.getOfficialWebsite());
        }
        if (updatedClient.getTaxName() != null) {
            existingClient.setTaxName(updatedClient.getTaxName());
        }
        if (updatedClient.getGstVatNumber() != null) {
            existingClient.setGstVatNumber(updatedClient.getGstVatNumber());
        }
        if (updatedClient.getOfficeNumber() != null) {
            existingClient.setOfficeNumber(updatedClient.getOfficeNumber());
        }
        if (updatedClient.getCity() != null) {
            existingClient.setCity(updatedClient.getCity());
        }
        if (updatedClient.getState() != null) {
            existingClient.setState(updatedClient.getState());
        }
        if (updatedClient.getPostalCode() != null) {
            existingClient.setPostalCode(updatedClient.getPostalCode());
        }
        if (updatedClient.getAddedBy() != null) {
            existingClient.setAddedBy(updatedClient.getAddedBy());
        }
        if (updatedClient.getCompanyAddress() != null) {
            existingClient.setCompanyAddress(updatedClient.getCompanyAddress());
        }
        if (updatedClient.getShoppingAddress() != null) {
            existingClient.setShoppingAddress(updatedClient.getShoppingAddress());
        }
        if (updatedClient.getNote() != null) {
            existingClient.setNote(updatedClient.getNote());
        }
        if (updatedClient.getCompanyLogo() != null) {
            existingClient.setCompanyLogo(updatedClient.getCompanyLogo());
        }
        if (updatedClient.getRole() != null) {
            existingClient.setRole(updatedClient.getRole());
        }
        if (updatedClient.getImageProfile() != null) {
            existingClient.setImageProfile(updatedClient.getImageProfile());
        }
        if (updatedClient.getImageProfileData() != null) {
            existingClient.setImageProfileData(updatedClient.getImageProfileData());
        }
        if (updatedClient.getImageLogo() != null) {
            existingClient.setImageLogo(updatedClient.getImageLogo());
        }
        if (updatedClient.getImageLogoData() != null) {
            existingClient.setImageLogoData(updatedClient.getImageLogoData());
        }

        return clientDao.save(existingClient);
    }

    @Transactional
    public void deleteClient(Long clientId) {
        Client client = clientDao.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        clientDao.delete(client);
    }
}