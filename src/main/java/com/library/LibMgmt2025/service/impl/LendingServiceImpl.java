package com.library.LibMgmt2025.service.impl;

import com.library.LibMgmt2025.dto.LendingDto;
import com.library.LibMgmt2025.service.LendingService;
import com.library.LibMgmt2025.util.UtilData;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class LendingServiceImpl implements LendingService {
    @Value("${perDayFine}")// value Injection
    private Double perDayAmount;
    @Override
    public void addLendingData(LendingDto lendingDto) {
    lendingDto.setLendingId(UtilData.generateLendingId());
    lendingDto.setLendingDate(String.valueOf(UtilData.generateTodayDate()));
    lendingDto.setReturnDate(String.valueOf(UtilData.generateBookReturnDate()));
    lendingDto.setIsActiveLending(true);
    lendingDto.setFineAmount(0.00);
    lendingDto.setOverDueDays(0L);
    System.out.println(lendingDto);
    }

    @Override
    public void handOverBook(String lendingId) {
        //Todo 1: check the details of the lending record - DB
        //Todo: check overdue and fine
    }

    @Override
    public void deleteLendingData(String lendingId) {

    }

    @Override
    public LendingDto getSelectedLendingData(String lendingId) {
        LendingDto lendingData = new LendingDto();
        lendingData.setLendingId("L001");
        lendingData.setBook("The Great Gatsby");
        lendingData.setMember("M12345");
        lendingData.setLendingDate("2025-01-01");
        lendingData.setReturnDate("2025-01-15");
        lendingData.setIsActiveLending(true);
        lendingData.setOverDueDays(2L);
        lendingData.setFineAmount(5.00);
        return lendingData;
    }

    @Override
    public List<LendingDto> getAllLendingData() {
        List<LendingDto> lendingDtoList = new ArrayList<>();

        LendingDto lending1 = new LendingDto();
        lending1.setLendingId("L001");
        lending1.setBook("The Great Gatsby");
        lending1.setMember("M001");
        lending1.setLendingDate("2025-02-10");
        lending1.setReturnDate("2025-02-20");
        lending1.setIsActiveLending(true);
        lending1.setOverDueDays(0L);
        lending1.setFineAmount(0.0);

        LendingDto lending2 = new LendingDto();
        lending2.setLendingId("L002");
        lending2.setBook("To Kill a Mockingbird");
        lending2.setMember("M002");
        lending2.setLendingDate("2025-02-05");
        lending2.setReturnDate("2025-02-15");
        lending2.setIsActiveLending(false);
        lending2.setOverDueDays(2L);
        lending2.setFineAmount(10.0);

        LendingDto lending3 = new LendingDto();
        lending3.setLendingId("L003");
        lending3.setBook("1984");
        lending3.setMember("M003");
        lending3.setLendingDate("2025-02-01");
        lending3.setReturnDate("2025-02-10");
        lending3.setIsActiveLending(false);
        lending3.setOverDueDays(5L);
        lending3.setFineAmount(25.0);

        LendingDto lending4 = new LendingDto();
        lending4.setLendingId("L004");
        lending4.setBook("Moby Dick");
        lending4.setMember("M004");
        lending4.setLendingDate("2025-02-12");
        lending4.setReturnDate("2025-02-22");
        lending4.setIsActiveLending(true);
        lending4.setOverDueDays(0L);
        lending4.setFineAmount(0.0);

        LendingDto lending5 = new LendingDto();
        lending5.setLendingId("L005");
        lending5.setBook("Pride and Prejudice");
        lending5.setMember("M005");
        lending5.setLendingDate("2025-02-08");
        lending5.setReturnDate("2025-02-18");
        lending5.setIsActiveLending(false);
        lending5.setOverDueDays(3L);
        lending5.setFineAmount(15.0);

        lendingDtoList.add(lending1);
        lendingDtoList.add(lending2);
        lendingDtoList.add(lending3);
        lendingDtoList.add(lending4);
        lendingDtoList.add(lending5);

        return lendingDtoList;
    }
    private Long calOverDue(){
        LocalDate today = UtilData.generateTodayDate();
        LocalDate returnDate = UtilData.generateBookReturnDateCalc();
        if (returnDate.isBefore(today)) {
            return ChronoUnit.DAYS.between(today, returnDate);
        }
        return 0L;
    }
    private Double calcFine(Long dataCount){
        return dataCount * perDayAmount;
    }
}
