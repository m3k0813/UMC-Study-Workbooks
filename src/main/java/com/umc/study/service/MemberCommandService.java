package com.umc.study.service;

import com.umc.study.domain.Member;
import com.umc.study.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);
}
