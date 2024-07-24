package com.youtube.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Proposal;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal,Long> {

}
