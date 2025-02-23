package com.library.LibMgmt2025.controller;

import com.library.LibMgmt2025.dto.LendingDto;
import com.library.LibMgmt2025.dto.MemberDto;
import com.library.LibMgmt2025.service.LendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/lendings")
@RequiredArgsConstructor
public class LendingController {
    private final LendingService lendingService;

    @GetMapping("health")
    public  String healthTest(){
        return "Lending Controller Running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addLending(@RequestBody LendingDto lendingDto){
       lendingService.addLendingData(lendingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteLending(@RequestParam("lendingId") String lendingId){
        lendingService.deleteLendingData(lendingId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{lendingId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> handOverBook(@PathVariable String lendingId , @RequestBody LendingDto lendingDetails){
        lendingService.handOverBook(lendingId, lendingDetails);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{lendingId}")
    public ResponseEntity<LendingDto> getSelectedLending(@PathVariable String lendingId){
         return ResponseEntity.ok(lendingService.getSelectedLendingData(lendingId));
    }

    @GetMapping
    public ResponseEntity<List<LendingDto>> getAllLendings(){
        return ResponseEntity.ok(lendingService.getAllLendingData());
    }
}
