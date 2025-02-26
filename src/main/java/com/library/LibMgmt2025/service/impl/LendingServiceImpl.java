package com.library.LibMgmt2025.service.impl;

import com.library.LibMgmt2025.dao.BookDao;
import com.library.LibMgmt2025.dao.LendingDao;
import com.library.LibMgmt2025.dao.MemberDao;
import com.library.LibMgmt2025.dto.LendingDto;
import com.library.LibMgmt2025.entity.BookEntity;
import com.library.LibMgmt2025.entity.LendingEntity;
import com.library.LibMgmt2025.entity.MemberEntity;
import com.library.LibMgmt2025.exception.*;
import com.library.LibMgmt2025.service.LendingService;
import com.library.LibMgmt2025.util.EntityDtoConvert;
import com.library.LibMgmt2025.util.LendingMapping;
import com.library.LibMgmt2025.util.UtilData;
import jdk.jshell.execution.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LendingServiceImpl implements LendingService {
    @Value("${perDayFine}")// value Injection
    private Double perDayAmount;
    private Double perDayFineAmount;
    private final LendingMapping lendingMapping ;
    private final BookDao bookDao;
    private final MemberDao memberDao;
    private final LendingDao lendingDao;
    private final EntityDtoConvert entityDTOConvert;
    @Override
    public void addLendingData(LendingDto lendingDto) {
        //relevant book
        //relevant member
        String bookId = lendingDto.getBook();
        String member = lendingDto.getMember();
        BookEntity bookEntity = bookDao.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book not found"));
        MemberEntity memberEntity = memberDao.findById(member).orElseThrow(() -> new MemberNotFoundException("Member Not Found"));
        // check the availability
        if(bookDao.avlilQty(bookId) > 0){
            // Books are available
            if(bookDao.deductBasedOnLending(bookId) > 0){
                //process the lending
                lendingDto.setLendingId(UtilData.generateLendingId());
                lendingDto.setLendingDate(UtilData.generateTodayDate());
                lendingDto.setReturnDate(UtilData.generateBookReturnDate());
                lendingDto.setIsActiveLending(true);
                lendingDto.setOverDueDays(0L);
                lendingDto.setFineAmount(0.0);
                lendingDao.save(LendingMapping.toLendingEntity(lendingDto, bookEntity, memberEntity));

            }else {
                throw new DataPersistNotFoundException("Cannot update book data with 0 available Qty");
            }
        }else {
            throw new EnoughBookNotFoundException("Not enough books to proceed");
        }
    }

    @Override
    public void handOverBook(String lendingId) {
        LendingEntity foundLending = lendingDao.findById(lendingId).orElseThrow(() -> new LendingNotFoundException("Lending data not found"));
        var returnDate = foundLending.getReturnDate();
        var overDue = calOverDue(returnDate); // overdue date count
        var fineAmount = calcFine(overDue); // calc fine against overdue dates

        foundLending.setOverdueDays(overDue);
        foundLending.setFineAmount(fineAmount);
        foundLending.setIsActiveLending(false);
        //update the book qty against the bookId
        bookDao.addBookBasedBookHandover(foundLending.getBook().getBookId());
    }

    @Override
    public void deleteLendingData(String lendingId) {

    }

    @Override
    public LendingDto getSelectedLendingData(String lendingId) {

        return null;
    }

    @Override
    public List<LendingDto> getAllLendingData() {

        return null;
    }
    private Long calOverDue(LocalDate returnDate) {
        LocalDate today = UtilData.generateTodayDate();
        if (returnDate.isBefore(today)) {
            return ChronoUnit.DAYS.between(today, returnDate);
        }
        return 0L;
    }
    private Double calcFine(Long dataCount){
        return dataCount * perDayAmount;
    }
}
