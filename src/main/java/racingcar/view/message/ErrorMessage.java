package racingcar.view.message;

public enum ErrorMessage {

    BLANK_INPUT_ERROR_FOR_CAR_NAMES("[ERROR] 공백은 입력할 수 없습니다."),
    NOT_NUMBER_ERROR_FOR_GAME_ROUND("[ERROR] 숫자만 입력이 가능합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
