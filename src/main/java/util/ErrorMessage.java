package util;

public enum ErrorMessage {
    ERROR_NAME_LENGTH("자동차 이름은 한 글자 이상 다섯 글자 이하여야 합니다."),
    ERROR_IS_BLANK_OR_NULL("자동차 이름을 입력해 주십시오."),
    ERROR_DUPLICATED_NAME("자동차의 이름은 중복될 수 없습니다."),
    ERROR_NAME_COUNT("자동차 이름은 2개 이상이어야 합니다."),
    ERROR_ROUND_IS_NULL("시도 횟수를 입력해 주십시오."),
    ERROR_ROUND_IS_NATURAL_NUMBER("시도 횟수는 자연수여야 합니다.");

    private static final String PREFIX_ERROR = "[ERROR] ";
    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX_ERROR + message;
    }
}
