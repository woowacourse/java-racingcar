package util.validator;

public class CarNameValidator extends Validator {
    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public void validate(String name) {
        validateCarNameLength(name);
    }


    private void validateCarNameLength(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(Message.EXCEPTION_CAR_NAME_BLANK.message);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Message.EXCEPTION_CAR_NAME_LENGTH.message);
        }
    }

    public enum Message {
        EXCEPTION_CAR_NAME_LENGTH("5자 이하의 이름을 입력해주세요."),
        EXCEPTION_CAR_NAME_BLANK("공백은 이름으로 사용할 수 없습니다");
        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
