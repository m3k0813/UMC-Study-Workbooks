package com.umc.study.apiPayload.exception.handler;

import com.umc.study.apiPayload.code.BaseErrorCode;
import com.umc.study.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
