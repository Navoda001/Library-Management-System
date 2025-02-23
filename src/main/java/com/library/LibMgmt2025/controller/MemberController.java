package com.library.LibMgmt2025.controller;

import com.library.LibMgmt2025.dto.MemberDto;
import com.library.LibMgmt2025.dto.StaffDto;
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

    @GetMapping("health")
    public  String healthTest(){
        return "Member Controller Running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addMember(@RequestBody MemberDto memberDto){
        memberService.saveMember(memberDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteMember(@RequestParam("memberId") String memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{memberId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateMember(@PathVariable String memberId , @RequestBody MemberDto memberDetails){
        memberService.updateMember(memberId, memberDetails);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{memberId}")
    public ResponseEntity<MemberDto> getSelectedMember(@PathVariable String memberId){
        return ResponseEntity.ok(memberService.getSelectedMember(memberId));
    }

    @GetMapping
    public ResponseEntity<List<MemberDto>> getAllStaffMembers(){
        return ResponseEntity.ok(memberService.getAllMembers());
    }
}
