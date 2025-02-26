package com.library.LibMgmt2025.service.impl;

import com.library.LibMgmt2025.dao.StaffDao;
import com.library.LibMgmt2025.dto.Role;
import com.library.LibMgmt2025.dto.StaffDto;
import com.library.LibMgmt2025.entity.StaffEntity;
import com.library.LibMgmt2025.exception.StaffNotFoundException;
import com.library.LibMgmt2025.service.StaffService;
import com.library.LibMgmt2025.util.EntityDtoConvert;
import com.library.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffDao staffDao;
    private final EntityDtoConvert entityDtoConvert;
    @Override
    public void saveStaff(StaffDto staffDto) {
        staffDto.setStaffId(UtilData.generateStaffId());
        staffDto.setLastUpdate(UtilData.generateTodayDate());
        staffDto.setLastupdateTime(UtilData.generatecurrentTime());
        staffDao.save(entityDtoConvert.convertStaffDtoToStaffEntity(staffDto));

    }

    @Override
    public void updateStaff(String staffId , StaffDto staffDto) {
        Optional<StaffEntity> foundStaffMember = staffDao.findById(staffId);
        if(!foundStaffMember.isPresent()) {
            throw new StaffNotFoundException("Staff Member Not Found");
        }
            foundStaffMember.get().setFirstName(staffDto.getFirstName());
        foundStaffMember.get().setLastName(staffDto.getLastName());
        foundStaffMember.get().setEmail(staffDto.getEmail());
        foundStaffMember.get().setJoinDate(staffDto.getJoinDate());
        foundStaffMember.get().setLastUpdate(UtilData.generateTodayDate());
        foundStaffMember.get().setLastUpdateTime(UtilData.generatecurrentTime());
        foundStaffMember.get().setPhone(staffDto.getPhone());
        foundStaffMember.get().setRole(staffDto.getRole());
    }

    @Override
    public void deleteStaff(String staffId) {
        Optional<StaffEntity> foundStaff = staffDao.findById(staffId);
        if (!foundStaff.isPresent()) {
            throw new StaffNotFoundException("Staff Member Not Found");
        }
        staffDao.deleteById(staffId);
    }

    @Override
    public StaffDto getSelectedStaffMember(String staffId) {
        if(! staffDao.findById(staffId).isPresent()) {
            throw new StaffNotFoundException("Staff Member Not Found");
        }
        return entityDtoConvert.convertStaffEntityToStaffDto(staffDao.getReferenceById(staffId));
    }

    @Override
    public List<StaffDto> getAllStaff() {
        return entityDtoConvert.toStaffDtoList(staffDao.findAll());
    }
}
