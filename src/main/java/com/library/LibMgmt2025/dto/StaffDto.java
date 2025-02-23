package com.library.LibMgmt2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDto implements Serializable {
    private int staffId;
    private String firstName;
    private String lastName;
    private String email;
    private String joinDate;
    private String phone;
    private Role role;



}
