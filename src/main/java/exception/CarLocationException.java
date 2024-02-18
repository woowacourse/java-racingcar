package exception;

public enum CarLocationException {
    NOT_NEGATIVE("[ERROR] 위치에는 음수가 입력될 수 없습니다.");

    private final String exceptionMessage;

    CarLocationException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

}
