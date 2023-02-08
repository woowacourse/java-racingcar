package exception;

import type.CarInformation;

public enum ErrorCode {
    CAR_NAME_OUT_OF_RANGE(String.format("차 이름 길이는 %d 글자 ~ %d 글자 사이여야 합니다.",
        CarInformation.NAME_MIN.getValue(), CarInformation.NAME_MAX.getValue())),
    CAR_NAME_DUPLICATE("이미 존재하는 차 이름입니다."),
    CAR_NOT_FOUND("존재하지 않는 차입니다."),
    CAR_EMPTY("차가 존재하지 않습니다."),
    CAR_NAMES_EMPTY("빈 값이 입력 되었습니다."),
    NOT_POSITIVE_NUMBER("양수만 입력 가능합니다."),
    ;
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
