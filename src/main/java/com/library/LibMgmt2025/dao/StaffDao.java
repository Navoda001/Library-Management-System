package com.library.LibMgmt2025.dao;

import com.library.LibMgmt2025.dto.StaffDto;
import com.library.LibMgmt2025.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StaffDao extends JpaRepository<StaffEntity,String> {
}
