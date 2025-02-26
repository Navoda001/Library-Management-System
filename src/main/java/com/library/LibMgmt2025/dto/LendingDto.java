package com.library.LibMgmt2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LendingDto implements Serializable {
    private String lendingId;
    private String book;
    private String member;
    private LocalDate lendingDate;
    private LocalDate returnDate;
    private Boolean isActiveLending;
    private Long overDueDays;
    private Double fineAmount;
}
