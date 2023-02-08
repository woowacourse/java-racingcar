package utils;

public enum ErrorMessage {
    COMMON("[ERROR] "),
    WRONG_NAME_LENGTH("1에서 5사이의 이름 길이만 입력 가능합니다."),
    WRONG_CARS_SIZE("차량의 대수가 최소 1대는 있어야 합니다."),
    WRONG_TRYTIMES("시도 횟수는 최소 1회 이상입니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String of() {
        return COMMON.message + message;
    }
}

