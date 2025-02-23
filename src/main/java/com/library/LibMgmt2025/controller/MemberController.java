package com.library.LibMgmt2025.controller;

import com.library.LibMgmt2025.dto.MemberDto;
import com.library.LibMgmt2025.dto.StaffDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {
    @GetMapping("health")
    public  String healthTest(){
        return "Member Controller Running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addMember(@RequestBody MemberDto memberDto){
        System.out.println(memberDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteMember(@RequestParam("memberId") String memberId){
        System.out.println(memberId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{memberId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateMember(@PathVariable String memberId , @RequestBody MemberDto memberDetails){
        System.out.println(memberId);
        System.out.println(memberDetails);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{memberId}")
    public ResponseEntity<MemberDto> getSelectedMember(@PathVariable String memberId){
        System.out.println("Get selected staff member for :"+memberId);
        return ResponseEntity.ok(new MemberDto());
    }

    public ResponseEntity<List<MemberDto>> getAllStaffMembers(){
        return ResponseEntity.ok(new ArrayList<>());
    }
}
