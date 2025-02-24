package com.library.LibMgmt2025.entity;

import com.library.LibMgmt2025.dto.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class StaffEntity {
    @Id
    private String staffId;
    private String firstName;
    private String lastName;
    private String email;
    private String joinDate;
    private String lastUpdate;
    private String phone;
    private Role role;
}
