package com.library.LibMgmt2025.service.impl;

import com.library.LibMgmt2025.dto.MemberDto;
import com.library.LibMgmt2025.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {


    @Override
    public void saveMember(MemberDto memberDto) {

    }

    @Override
    public void updateMember(String memberId, MemberDto memberDto) {

    }

    @Override
    public void deleteMember(String memberId) {

    }

    @Override
    public MemberDto getSelectedMember(String memberId) {
        MemberDto member = new MemberDto();
        member.setMemberId("M12345");
        member.setName("John Doe");
        member.setEmail("john.doe@gmail.com");
        member.setMembershipDate("2025-01-18");
        return member;
    }

    @Override
    public List<MemberDto> getAllMembers() {
       List<MemberDto> members = new ArrayList<>();

       MemberDto member1 = new MemberDto();
       member1.setMemberId("M12345");
       member1.setName("John Doe");
       member1.setEmail("john.doe@gmail.com");
       member1.setMembershipDate("2025-01-18");

       MemberDto member2 = new MemberDto();
       member2.setMemberId("M12346");
       member2.setName("Jane Smith");
       member2.setEmail("jane.smith@gmail.com");
       member2.setMembershipDate("2025-02-18");

       MemberDto member3 = new MemberDto();
       member3.setMemberId("M12347");
       member3.setName("Charlie Davis");
       member3.setEmail("charlie.davis@gmail.com");
       member3.setMembershipDate("2025-01-01");

       MemberDto member4 = new MemberDto();
       member4.setMemberId("M12348");
       member4.setName("Charlie Smith");
       member4.setEmail("charlie.smith@gmail.com");
       member4.setMembershipDate("2025-02-26");

       MemberDto member5 = new MemberDto();
       member5.setMemberId("M12349");
       member5.setName("Jane David");
       member5.setEmail("jane.david@gmail.com");
       member5.setMembershipDate("2025-01-21");

       members.add(member1);
       members.add(member2);
       members.add(member3);
       members.add(member4);

       return members;
    }
}
