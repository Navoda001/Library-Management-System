package com.library.LibMgmt2025.service;

import com.library.LibMgmt2025.dto.StaffDto;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDto staffDto);
    void updateStaff(String staffId , StaffDto staffDto);
    void deleteStaff(String staffId);
    StaffDto getSelectedStaffMember(String staffId);
    List<StaffDto> getAllStaff();
}
