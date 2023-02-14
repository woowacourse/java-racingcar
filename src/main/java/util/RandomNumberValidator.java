package util;

public class RandomNumberValidator {
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 0;

    private RandomNumberValidator() {
    }

    public static void validate(int number) {
        if (number > MAX_VALUE || number < MIN_VALUE) {
            throw new IllegalArgumentException(Message.EXCEPTION_NUMBER_RANGE.message);
        }
    }

    public enum Message {
        EXCEPTION_NUMBER_RANGE("0이상 9이하의 수가 아닙니다.");
        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
