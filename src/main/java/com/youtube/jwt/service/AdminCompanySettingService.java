package com.youtube.jwt.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.AdminCompanySettingDao;
import com.youtube.jwt.entity.AdminCompanySetting;


@Service
public class AdminCompanySettingService {
@Autowired
private AdminCompanySettingDao adminCompanySettingDao;

public AdminCompanySetting savedata(AdminCompanySetting adminCompanySetting) {
	AdminCompanySetting savedData = adminCompanySettingDao.save(adminCompanySetting);
     return savedData;
}

public List<AdminCompanySetting> getSaveAccount() {
	return adminCompanySettingDao.findAll();
}

@Transactional
public AdminCompanySetting updateAdminCompanySetting(Long companyId, AdminCompanySetting updatedCompanySetting) {
    Optional<AdminCompanySetting> existingCompanySettingOpt = adminCompanySettingDao.findById(companyId);

    if (existingCompanySettingOpt.isPresent()) {
        AdminCompanySetting existingCompanySetting = existingCompanySettingOpt.get();

        if (updatedCompanySetting.getCompanyName() != null) {
            existingCompanySetting.setCompanyName(updatedCompanySetting.getCompanyName());
        }
        if (updatedCompanySetting.getCompanyEmail() != null) {
            existingCompanySetting.setCompanyEmail(updatedCompanySetting.getCompanyEmail());
        }
        if (updatedCompanySetting.getCompanyPhone() != null) {
            existingCompanySetting.setCompanyPhone(updatedCompanySetting.getCompanyPhone());
        }
        if (updatedCompanySetting.getCompanyWebsite() != null) {
            existingCompanySetting.setCompanyWebsite(updatedCompanySetting.getCompanyWebsite());
        }
        if (updatedCompanySetting.getCompanyLogo() != null) {
            existingCompanySetting.setCompanyLogo(updatedCompanySetting.getCompanyLogo());
        }
        if (updatedCompanySetting.getFileData() != null) {
            existingCompanySetting.setFileData(updatedCompanySetting.getFileData());
        }

        return adminCompanySettingDao.save(existingCompanySetting);
    } else {
        throw new RuntimeException("AdminCompanySetting not found with ID: " + companyId);
    }
}

    @Transactional
     public void deleteAdminCompanySetting(Long companyId) {
       if (adminCompanySettingDao.existsById(companyId)) {
    	   adminCompanySettingDao.deleteById(companyId);
        } else {
        throw new RuntimeException("AdminCompanySetting not found with ID: " + companyId);
         }
}

}
