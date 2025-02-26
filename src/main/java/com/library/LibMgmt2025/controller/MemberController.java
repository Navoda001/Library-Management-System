package com.library.LibMgmt2025.controller;

import com.library.LibMgmt2025.dto.MemberDto;
import com.library.LibMgmt2025.dto.StaffDto;
import com.library.LibMgmt2025.exception.MemberNotFoundException;
import com.library.LibMgmt2025.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addMember(@RequestBody MemberDto memberDto){
        if (memberDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        memberService.saveMember(memberDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteMember(@RequestParam("memberId") String memberId){
        if (memberId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            memberService.deleteMember(memberId);
            return ResponseEntity.noContent().build();
        }catch (MemberNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateMember(@RequestParam String memberId , @RequestBody MemberDto memberDetails){
        if (memberId == null || memberDetails == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    try {
        memberService.updateMember(memberId, memberDetails);
        return ResponseEntity.noContent().build();
    }catch (MemberNotFoundException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }

    @GetMapping
    public ResponseEntity<MemberDto> getSelectedMember(@RequestParam("memberId") String memberId){
        if (memberId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            return ResponseEntity.ok(memberService.getSelectedMember(memberId));
        }catch (MemberNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getAllMember")
    public ResponseEntity<List<MemberDto>> getAllStaffMembers(){
        return ResponseEntity.ok(memberService.getAllMembers());
    }
}
