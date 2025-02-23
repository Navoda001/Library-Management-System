package com.library.LibMgmt2025.controller;

import com.library.LibMgmt2025.dto.BookDto;
import com.library.LibMgmt2025.dto.StaffDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {
    @GetMapping("health")
    public  String healthTest(){
        return "Staff Controller Running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addStaff(@RequestBody StaffDto staffDto){
        System.out.println(staffDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteStaff(@RequestParam("staffId") String staffId){
        System.out.println(staffId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{staffId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaff(@PathVariable String staffId , @RequestBody StaffDto staffMemberDetails){
        System.out.println(staffMemberDetails);
        System.out.println(staffId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{staffId}")
    public ResponseEntity<StaffDto> getSelectedBook(@PathVariable String staffId){
        System.out.println("Get selected staff member for :"+staffId);
        return ResponseEntity.ok(new StaffDto());
    }

    public ResponseEntity<List<StaffDto>> getAllStaffMembers(){
        return ResponseEntity.ok(new ArrayList<>());
    }

}
