package exception;

public enum CarNameException {
    INVALID_LENGTH("[ERROR] 이름의 길이는 1자 이상, 5자 이하여야 합니다. 다시 입력해 주세요.");

    private final String exceptionMessage;

    CarNameException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
