package com.library.LibMgmt2025.util;

import com.library.LibMgmt2025.dto.LendingDto;
import com.library.LibMgmt2025.entity.BookEntity;
import com.library.LibMgmt2025.entity.LendingEntity;
import com.library.LibMgmt2025.entity.MemberEntity;

public class LendingMapping {
    public static LendingDto toLendingDto(LendingEntity lendingEntity) {
        LendingDto lendingDto = new LendingDto();
    lendingDto.setLendingId(lendingEntity.getLendingId());
    lendingDto.setBook(lendingEntity.getBook().getBookId());
    lendingDto.setMember(lendingEntity.getMember().getMemberId());
    lendingDto.setLendingDate(lendingEntity.getLendingDate());
    lendingDto.setReturnDate(lendingEntity.getReturnDate());
    lendingDto.setIsActiveLending(lendingEntity.getIsActiveLending());
    lendingDto.setOverDueDays(lendingEntity.getOverdueDays());
    lendingDto.setFineAmount(lendingEntity.getFineAmount());
    return lendingDto;
    }
    public static LendingEntity toLendingEntity(LendingDto lendingDto, BookEntity bookEntity, MemberEntity memberEntity) {
        LendingEntity lendingEntity = new LendingEntity();
        lendingEntity.setLendingId(lendingDto.getLendingId());
        lendingEntity.setBook(bookEntity);
        lendingEntity.setMember(memberEntity);
        lendingEntity.setLendingDate(lendingDto.getLendingDate());
        lendingEntity.setReturnDate(lendingDto.getReturnDate());
        lendingEntity.setIsActiveLending(lendingDto.getIsActiveLending());
        lendingEntity.setOverdueDays(lendingDto.getOverDueDays());
        lendingEntity.setFineAmount(lendingDto.getFineAmount());
        return lendingEntity;

    }
}

