package com.library.LibMgmt2025.dao;

import com.library.LibMgmt2025.entity.LendingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendingDao extends JpaRepository<LendingEntity,String> {
}
