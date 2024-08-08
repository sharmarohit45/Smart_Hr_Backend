package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.youtube.jwt.entity.Contracts;
import com.youtube.jwt.entity.Department;
import com.youtube.jwt.service.ContractService;

@RestController
public class ContractController {
	@Autowired
	private ContractService contractService;
	
	@PostMapping("/contract")
    public ResponseEntity<Contracts> saveContract(@RequestBody Contracts contracts) {
        Contracts savedContract = contractService.saveContract(contracts);
        return ResponseEntity.ok(savedContract);
    }
	@GetMapping("/contract")
	 public List<Contracts> getAllContracts() {
       return contractService.getAllContracts();
   }
	@GetMapping("/contract/{contractId}")
	public ResponseEntity<Contracts> getContractById(@PathVariable Long contractId) {
		Contracts contracts = contractService.getContractIdById(contractId);
		return ResponseEntity.ok(contracts);
	}
	@DeleteMapping("/contract/{contractId}")
    public ResponseEntity<String> deleteClient(@PathVariable Long contractId) {
		contractService.deleteContract(contractId);
        return ResponseEntity.ok("Contract deleted successfully");
    }
}
