package com.library.LibMgmt2025.dao;

import com.library.LibMgmt2025.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends JpaRepository<MemberEntity, String> {
}
