package com.library.LibMgmt2025.controller;

import com.library.LibMgmt2025.dto.BookDto;
import com.library.LibMgmt2025.dto.StaffDto;
import com.library.LibMgmt2025.exception.StaffNotFoundException;
import com.library.LibMgmt2025.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addStaff(@RequestBody StaffDto staffDto){
        if(staffDto == null){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        staffService.saveStaff(staffDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteStaff(@RequestParam("staffId") String staffId){
        if(staffId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            staffService.deleteStaff(staffId);
            return ResponseEntity.noContent().build();
        }catch (StaffNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PatchMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaff(@RequestParam String staffId , @RequestBody StaffDto staffMemberDetails){
        if (staffMemberDetails == null || staffId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            staffService.updateStaff(staffId,staffMemberDetails);
            return ResponseEntity.noContent().build();
        }catch (StaffNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("{staffId}")
    public ResponseEntity<StaffDto> getSelectedBook(@PathVariable String staffId){
        return ResponseEntity.ok(staffService.getSelectedStaffMember(staffId));
    }

    @GetMapping
    public ResponseEntity<List<StaffDto>> getAllStaffMembers(){
        return ResponseEntity.ok(staffService.getAllStaff());
    }

}
