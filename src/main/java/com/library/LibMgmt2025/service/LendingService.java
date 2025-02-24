package com.library.LibMgmt2025.service;

import com.library.LibMgmt2025.dto.LendingDto;

import java.util.List;

public interface LendingService {
    void addLendingData (LendingDto lendingDto);
    void handOverBook (String lendingId);
    void deleteLendingData (String lendingId);
    LendingDto getSelectedLendingData (String lendingId);
    List<LendingDto> getAllLendingData();
}
