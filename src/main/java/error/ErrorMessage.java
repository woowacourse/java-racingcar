package error;

import domain.Name;
import domain.TryCount;

public enum ErrorMessage {
    DUPLICATED_NAMES("중복된 이름이 존재합니다."),
    INVALID_NAME_LENGTH("이름은 " + Name.MAX_NAME_LENGTH + "글자 이하여야 합니다."),
    INVALID_COUNT("시도 횟수는 " + TryCount.MIN_COUNT + "회 이상이여야 합니다."),
    IS_NOT_NUMERIC("숫자를 입력해야 합니다.");

    private final String value;
    private static final String ERROR_HEAD = "[ERROR]: %s";

    ErrorMessage(String message) {
        this.value = String.format(ERROR_HEAD, message);
    }

    public String getValue() {
        return value;
    }
}
