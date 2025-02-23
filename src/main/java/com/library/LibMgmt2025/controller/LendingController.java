package com.library.LibMgmt2025.controller;

import com.library.LibMgmt2025.dto.LendingDto;
import com.library.LibMgmt2025.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/lendings")
public class LendingController {
    @GetMapping("health")
    public  String healthTest(){
        return "Lending Controller Running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addLending(@RequestBody LendingDto lendingDto){
        System.out.println(lendingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteLending(@RequestParam("lendingId") String lendingId){
        System.out.println(lendingId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{lendingId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> handOverBook(@PathVariable String lendingId , @RequestBody LendingDto lendingDetails){
        System.out.println(lendingId);
        System.out.println(lendingDetails);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{lendingId}")
    public ResponseEntity<LendingDto> getSelectedLending(@PathVariable String lendingId){
        System.out.println("Get selected Lending for :"+lendingId);
        return ResponseEntity.ok(new LendingDto());
    }

    public ResponseEntity<List<LendingDto>> getAllLendings(){
        return ResponseEntity.ok(new ArrayList<>());
    }
}
