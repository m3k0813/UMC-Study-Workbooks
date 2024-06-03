package com.umc.study.converter;

import com.umc.study.domain.FoodCategory;
import com.umc.study.domain.Mapping.MemberPrefer;
import com.umc.study.domain.Member;
import com.umc.study.domain.enums.Gender;
import com.umc.study.dto.MemberRequestDTO;
import com.umc.study.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public class MemberPreferConverter {

        public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList){

            return foodCategoryList.stream()
                    .map(foodCategory ->
                            MemberPrefer.builder()
                                    .foodCategory(foodCategory)
                                    .build()
                    ).collect(Collectors.toList());
        }
    }

}