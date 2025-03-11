package com.library.LibMgmt2025.util;

import com.library.LibMgmt2025.dto.BookDto;
import com.library.LibMgmt2025.dto.LendingDto;
import com.library.LibMgmt2025.dto.MemberDto;
import com.library.LibMgmt2025.dto.StaffDto;
import com.library.LibMgmt2025.dto.secure.UserDTO;
import com.library.LibMgmt2025.entity.BookEntity;
import com.library.LibMgmt2025.entity.LendingEntity;
import com.library.LibMgmt2025.entity.MemberEntity;
import com.library.LibMgmt2025.entity.StaffEntity;
import com.library.LibMgmt2025.entity.secure.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EntityDtoConvert {
    private final ModelMapper modelMapper;

    //Book
    public BookEntity convertBookDtoToBookEntity(BookDto bookDto) {
        return modelMapper.map(bookDto, BookEntity.class);
    }
    public BookDto convertBookEntityToBookDto(BookEntity bookEntity) {
        return modelMapper.map(bookEntity, BookDto.class);
    }
    public List<BookDto> toBookDtoList(List<BookEntity> bookEntityList) {
        return modelMapper.map(bookEntityList,new TypeToken<List<BookDto>>(){}.getType());
    }
    //Member
    public MemberEntity convertMemberDtoToMemberEntity(MemberDto memberDto) {
        return modelMapper.map(memberDto, MemberEntity.class);
    }
    public MemberDto convertMemberEntityToMemberDto(MemberEntity memberEntity) {
        return modelMapper.map(memberEntity, MemberDto.class);
    }
    public List<MemberDto> toMemberDtoList(List<MemberEntity> memberEntityList) {
        return modelMapper.map(memberEntityList,new TypeToken<List<MemberDto>>(){}.getType());
    }
    //Staff
    public StaffEntity convertStaffDtoToStaffEntity(StaffDto staffDto) {
        return modelMapper.map(staffDto, StaffEntity.class);
    }
    public StaffDto convertStaffEntityToStaffDto(StaffEntity staffEntity) {
        return modelMapper.map(staffEntity, StaffDto.class);
    }
    public List<StaffDto> toStaffDtoList(List<StaffEntity> staffEntityList) {
        return modelMapper.map(staffEntityList,new TypeToken<List<StaffDto>>(){}.getType());
    }
    //user
    public UserDTO toUserDto(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public UserEntity toUserEntity(UserDTO userDto) {
        return modelMapper.map(userDto, UserEntity.class);
    }
}
