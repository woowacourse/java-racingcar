package racingcar.exception.status.reader;

import racingcar.exception.status.ExceptionStatus;

public enum ReaderExceptionStatus implements ExceptionStatus {

    READER_CANNOT_READ("입력을 받아올 수 없습니다.");

    private final String message;

    ReaderExceptionStatus(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
