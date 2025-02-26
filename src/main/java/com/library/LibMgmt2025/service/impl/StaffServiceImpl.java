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
        staffDao.save(entityDtoConvert.convertStaffDtoToStaffEntity(staffDto));

    }

    @Override
    public void updateStaff(String staffId , StaffDto staffDto) {

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
        StaffDto staff = new StaffDto();
        staff.setStaffId("S001");
        staff.setFirstName("James");
        staff.setLastName("Brown");
        staff.setEmail("james.brown@gmail.com");
        staff.setJoinDate("2025-01-18");
        staff.setPhone("0777777777");
        staff.setRole(Role.ADMIN);

        return staff;
    }

    @Override
    public List<StaffDto> getAllStaff() {
        List<StaffDto> staffList = new ArrayList<>();

        StaffDto staff1 = new StaffDto();
        staff1.setStaffId("S001");
        staff1.setFirstName("James");
        staff1.setLastName("Brown");
        staff1.setEmail("james.brown@gmail.com");
        staff1.setJoinDate("2025-01-18");
        staff1.setRole(Role.ADMIN);

        StaffDto staff2 = new StaffDto();
        staff2.setStaffId("S002");
        staff2.setFirstName("Charlie");
        staff2.setLastName("Davis");
        staff2.setEmail("charlie.davis@gmail.com");
        staff2.setJoinDate("2025-02-18");
        staff2.setRole(Role.ADMIN);

        StaffDto staff3 = new StaffDto();
        staff3.setStaffId("S003");
        staff3.setFirstName("Jack");
        staff3.setLastName("Brown");
        staff3.setEmail("jack.brown@gmail.com");
        staff3.setJoinDate("2024-03-18");
        staff3.setRole(Role.OFFICER);

        StaffDto staff4 = new StaffDto();
        staff4.setStaffId("S004");
        staff4.setFirstName("John");
        staff4.setLastName("Doe");
        staff4.setEmail("john.doe@gmail.com");
        staff4.setJoinDate("2025-04-18");
        staff4.setRole(Role.LIBRARIAN);

        staffList.add(staff1);
        staffList.add(staff2);
        staffList.add(staff3);
        staffList.add(staff4);

        return staffList;
    }
}
