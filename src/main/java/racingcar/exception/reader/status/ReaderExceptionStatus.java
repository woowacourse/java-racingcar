package racingcar.exception.reader.status;

public enum ReaderExceptionStatus {

    READER_CANNOT_READ_EXCEPTION_STATUS("입력을 받아올 수 없습니다.");

    private final String message;

    ReaderExceptionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
