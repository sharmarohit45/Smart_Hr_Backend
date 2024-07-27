package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.youtube.jwt.dao.AdminBankAccountDao;
import com.youtube.jwt.entity.AdminAccount;
import com.youtube.jwt.exception.EntityNotFoundException;

@Service
public class AdminBankAccountService {
	@Autowired
	private AdminBankAccountDao adminBankAccountDao;

	public AdminAccount saveAccount(AdminAccount adminAccount) {
		return adminBankAccountDao.save(adminAccount);
	}

	public List<AdminAccount> getSaveAccount() {
		return adminBankAccountDao.findAll();
	}

	public void deleteAccount(Long accountID) {
		Optional<AdminAccount> optionalAccount = adminBankAccountDao.findById(accountID);
		if (optionalAccount.isPresent()) {
			adminBankAccountDao.delete(optionalAccount.get());
		} else {
			throw new EntityNotFoundException("AdminAccount not found with id " + accountID);
		}
	}
	
	@Transactional
    public AdminAccount updateAdminAccount(Long accountID, AdminAccount updatedAccount) {
        Optional<AdminAccount> existingAccountOpt = adminBankAccountDao.findById(accountID);

        if (existingAccountOpt.isPresent()) {
            AdminAccount existingAccount = existingAccountOpt.get();

            if (updatedAccount.getBankName() != null) {
                existingAccount.setBankName(updatedAccount.getBankName());
            }
            if (updatedAccount.getAccountHolderName() != null) {
                existingAccount.setAccountHolderName(updatedAccount.getAccountHolderName());
            }
            if (updatedAccount.getAccountNumber() != null) {
                existingAccount.setAccountNumber(updatedAccount.getAccountNumber());
            }
            if (updatedAccount.getAccountType() != null) {
                existingAccount.setAccountType(updatedAccount.getAccountType());
            }
            if (updatedAccount.getCurrency() != null) {
                existingAccount.setCurrency(updatedAccount.getCurrency());
            }
            if (updatedAccount.getContactNumber() != null) {
                existingAccount.setContactNumber(updatedAccount.getContactNumber());
            }
            if (updatedAccount.getOpeningBalance() != null) {
                existingAccount.setOpeningBalance(updatedAccount.getOpeningBalance());
            }
            if (updatedAccount.getStatus() != null) {
                existingAccount.setStatus(updatedAccount.getStatus());
            }
            if (updatedAccount.getCashAccountHolderName() != null) {
                existingAccount.setCashAccountHolderName(updatedAccount.getCashAccountHolderName());
            }
            if (updatedAccount.getCashAccountNumber() != null) {
                existingAccount.setCashAccountNumber(updatedAccount.getCashAccountNumber());
            }
            if (updatedAccount.getOpeningAmount() != null) {
                existingAccount.setOpeningAmount(updatedAccount.getOpeningAmount());
            }
            if (updatedAccount.getCashContactNumber() != null) {
                existingAccount.setCashContactNumber(updatedAccount.getCashContactNumber());
            }
            if (updatedAccount.getCashStatus() != null) {
                existingAccount.setCashStatus(updatedAccount.getCashStatus());
            }
            if (updatedAccount.getBankData() != null) {
                existingAccount.setBankData(updatedAccount.getBankData());
            }

            return adminBankAccountDao.save(existingAccount);
        } else {
            throw new RuntimeException("AdminAccount not found with ID: " + accountID);
        }
    }

}
