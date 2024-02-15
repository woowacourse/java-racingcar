package constant;

public enum Exception {
    INPUT_NULL_BLANK("입력은 없거나 null일 수 없습니다"),
    INPUT_NUMERIC("숫자가 입력되지 않았습니다.")
    ;


    private final String message;

    Exception(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
