package com.library.LibMgmt2025.service.impl;

import com.library.LibMgmt2025.dao.MemberDao;
import com.library.LibMgmt2025.dto.MemberDto;
import com.library.LibMgmt2025.service.MemberService;
import com.library.LibMgmt2025.util.EntityDtoConvert;
import com.library.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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

    }

    @Override
    public void deleteMember(String memberId) {

    }

    @Override
    public MemberDto getSelectedMember(String memberId) {

        return null;
    }

    @Override
    public List<MemberDto> getAllMembers() {

       return null;
    }
}
