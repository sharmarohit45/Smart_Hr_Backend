package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.ClientDao;
import com.youtube.jwt.dao.ContractDao;
import com.youtube.jwt.entity.Client;
import com.youtube.jwt.entity.Contracts;
import com.youtube.jwt.entity.Department;

@Service
public class ContractService {
	@Autowired
	private ContractDao contractDao;
	@Autowired
	private ClientDao clientDao;

	public List<Contracts> getAllContracts() {
		
		return contractDao.findAll();
	}

	public Contracts saveContract(Contracts contract) {
		Client client = clientDao.findById(contract.getClientIId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
                contract.setClient(client);
        return contractDao.save(contract);
    }
	public Contracts getContractIdById(Long contractId) {
        return contractDao.findById(contractId)
                .orElseThrow(() -> new RuntimeException("contract not found"));
    }
	public void deleteContract(Long contractId) {
		contractDao.deleteById(contractId);
    }
	
}