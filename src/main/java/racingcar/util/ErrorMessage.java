package racingcar.util;

public enum ErrorMessage {
    ERROR_NULL("[ERROR] 입력값은 NULL일 수 없습니다."),
    ERROR_BLANK("[ERROR] 입력값은 빈 입력일 수 없습니다."),
    ERROR_SIZE("[ERROR] 입력값의 크기는 5 초과일 수 없습니다."),
    ERROR_SPECIAL_CHAR("[ERROR] 입력값은 특수문자일 수 없습니다."),
    ERROR_DUPLICATE("[ERROR] 입력값은 중복될 수 없습니다."),
    ERROR_INT_NUM("[ERROR] 입력값은 문자일 수 없습니다."),
    ERROR_NO_CAR("[ERROR] 쉼표를 기준으로 차가 한 대 이상 있어야 합니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
