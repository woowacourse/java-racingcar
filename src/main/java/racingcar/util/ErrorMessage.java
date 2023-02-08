package racingcar.util;

public enum ErrorMessage {
    CAR_NAME_DUPLICATED("[ERROR] 중복된 차 이름이 존재합니다."),
    CAR_NAME_NULL("[ERROR] 비어있는 자동차 이름이 들어있습니다."),
    INVALID_CAR_NAME_FORMAT("[ERROR] 문자와 숫자가 아닌 자동차 이름이 들어있습니다."),
    CAR_NAME_OVER_RANGE("[ERROR] 다섯 글자가 넘는 자동차 이름이 들어있습니다."),

    INVALID_TRIAL_NUMBER("[ERROR] 시도 횟수는 정수만 입력 가능합니다."),
    TRIAL_NUMBER_OVER_RANGE("[ERROR] 시도 횟수가 100 이하여야 합니다."),
    TRIAL_NUMBER_UNDER_RANGE("[ERROR] 시도 횟수가 1 이상이어야 합니다."),
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
