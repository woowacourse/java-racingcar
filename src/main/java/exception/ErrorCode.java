package exception;

import type.CarInformation;

public enum ErrorCode {
    CAR_NAME_OUT_OF_RANGE(
        String.format("차 이름 길이는 %d 글자 ~ %d 글자 사이여야 합니다.", CarInformation.NAME_MIN.getValue(),
            CarInformation.NAME_MAX.getValue()));
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
