package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.dao.AssetsDao;
import com.youtube.jwt.entity.AssetsData;


@Service
public class Assets {

	@Autowired
	private AssetsDao assetsDao;
	
	public AssetsData saveAssets(AssetsData assetsData) {
		AssetsData savedAssetsData = assetsDao.save(assetsData);
		return savedAssetsData;
	}
	public List<AssetsData> getAllAssets()
	{
		return assetsDao.findAll();
	}
	public void deleteAssets(Long assetsId) {
		assetsDao.deleteById(assetsId);
    }
}
