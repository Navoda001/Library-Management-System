package com.library.LibMgmt2025.service.impl;

import com.library.LibMgmt2025.dao.MemberDao;
import com.library.LibMgmt2025.dto.MemberDto;
import com.library.LibMgmt2025.entity.MemberEntity;
import com.library.LibMgmt2025.exception.MemberNotFoundException;
import com.library.LibMgmt2025.service.MemberService;
import com.library.LibMgmt2025.util.EntityDtoConvert;
import com.library.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

private final MemberDao memberDao;
    private final EntityDtoConvert entityDtoConvert;

    @Override
    public void saveMember(MemberDto memberDto) {
    memberDto.setMemberId(UtilData.generateMemberId());
    memberDto.setMembershipDate(UtilData.generateTodayDate());
    memberDao.save(entityDtoConvert.convertMemberDtoToMemberEntity(memberDto));
    }

    @Override
    public void updateMember(String memberId, MemberDto memberDto) {
        Optional<MemberEntity> foundMember = memberDao.findById(memberId);
    if (!foundMember.isPresent()) {
        throw new MemberNotFoundException();
    }
        foundMember.get().setName(memberDto.getName());
    foundMember.get().setEmail(memberDto.getEmail());
    foundMember.get().setMembershipDate(UtilData.generateTodayDate());
    }

    @Override
    public void deleteMember(String memberId) {
        Optional<MemberEntity> foundMember = memberDao.findById(memberId);
        if (!foundMember.isPresent()) {
            throw new MemberNotFoundException("Member not found");
        }
            memberDao.deleteById(memberId);
    }

    @Override
    public MemberDto getSelectedMember(String memberId) {
        Optional<MemberEntity> foundMember = memberDao.findById(memberId);
        if (!foundMember.isPresent()) {
            throw new MemberNotFoundException("Member not found");
        }
        return entityDtoConvert.convertMemberEntityToMemberDto(memberDao.getReferenceById(memberId));
    }

    @Override
    public List<MemberDto> getAllMembers() {

       return null;
    }
}
