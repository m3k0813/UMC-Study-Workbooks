package com.umc.study.service;

import com.umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import com.umc.study.apiPayload.code.status.ErrorStatus;
import com.umc.study.converter.MemberConverter;
import com.umc.study.domain.FoodCategory;
import com.umc.study.domain.Mapping.MemberPrefer;
import com.umc.study.domain.Member;
import com.umc.study.dto.MemberRequestDTO;
import com.umc.study.repository.FoodCategoryRepository;
import com.umc.study.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional()
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberConverter.MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> { memberPrefer.setMember(newMember); });

        return memberRepository.save(newMember);
    }
}
