package com.library.LibMgmt2025.dao.secure;

import com.library.LibMgmt2025.entity.secure.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<UserEntity,String> {
Optional<UserEntity> findByEmail(String email);
}
