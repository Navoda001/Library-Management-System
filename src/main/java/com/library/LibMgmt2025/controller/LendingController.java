package com.library.LibMgmt2025.controller;

import com.library.LibMgmt2025.dto.LendingDto;
import com.library.LibMgmt2025.dto.MemberDto;
import com.library.LibMgmt2025.exception.*;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addLending(@RequestBody LendingDto lendingDto){
        if(lendingDto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            lendingService.addLendingData(lendingDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (BookNotFoundException | MemberNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (DataPersistNotFoundException | EnoughBookNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteLending(@RequestParam("lendingId") String lendingId){
        lendingService.deleteLendingData(lendingId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping
    public ResponseEntity<Void> handOverBook(@RequestParam String lendingId){
        try {
            System.out.println(lendingId);
            lendingService.handOverBook(lendingId);
            return ResponseEntity.noContent().build();
        }catch (LendingNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
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
