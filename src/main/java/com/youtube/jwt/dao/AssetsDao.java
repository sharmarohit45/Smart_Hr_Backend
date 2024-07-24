package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.AssetsData;
@Repository
public interface AssetsDao extends JpaRepository<AssetsData, Long> {

}
