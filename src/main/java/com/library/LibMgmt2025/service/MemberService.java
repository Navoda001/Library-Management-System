package com.library.LibMgmt2025.service;

import com.library.LibMgmt2025.dto.MemberDto;

import java.util.List;

public interface MemberService {
    void saveMember(MemberDto memberDto);
    void updateMember(String memberId,MemberDto memberDto);
    void deleteMember(String memberId);
    MemberDto getSelectedMember(String memberId);
    List<MemberDto> getAllMembers();

}
