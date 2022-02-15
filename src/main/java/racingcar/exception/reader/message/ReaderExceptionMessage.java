package racingcar.exception.reader.message;

public enum ReaderExceptionMessage {

    READER_CANNOT_READ("입력을 받아올 수 없습니다.");

    private final String message;

    ReaderExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
