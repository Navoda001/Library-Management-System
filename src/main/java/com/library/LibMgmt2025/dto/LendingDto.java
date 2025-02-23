package com.library.LibMgmt2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LendingDto implements Serializable {
    private String lendingId;
    private String book;
    private String member;
    private String lendingDate;
    private String returnDate;
    private Boolean isActiveLending;
    private Long overDueDays;
    private Double fineAmount;
}
