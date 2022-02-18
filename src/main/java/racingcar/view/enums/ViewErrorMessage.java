package racingcar.view.enums;

public enum ViewErrorMessage {
    EMPTY_INPUT_ERROR_MESSAGE("입력값이 없습니다.");

    private final String message;

    ViewErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
