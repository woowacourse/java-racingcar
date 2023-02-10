package util;

import java.util.List;

public class CarNameValidator {
    public static final int MIN_CAR_NUMBER = 2;
    public static final int MAX_NAME_LENGTH = 5;

    public void validate(List<String> names) {
        validateCarNumber(names);
        names.forEach(this::validateCarNameLength);
    }

    private void validateCarNumber(List<String> names) {
        if (names.size() < MIN_CAR_NUMBER) {
            throw new IllegalArgumentException(Message.EXCEPTION_CAR_NUMBER.message);
        }
    }

    private void validateCarNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Message.EXCEPTION_CAR_NAME_LENGTH.message);
        }
    }

    public enum Message {
        EXCEPTION_CAR_NUMBER("2개 이상의 자동차를 입력해 주세요."),
        EXCEPTION_CAR_NAME_LENGTH("5자 이하의 이름을 입력해주세요.");
        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

}
