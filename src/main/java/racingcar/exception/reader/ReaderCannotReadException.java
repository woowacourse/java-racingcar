package racingcar.exception.reader;

import static racingcar.exception.reader.status.ReaderExceptionStatus.READER_CANNOT_READ_EXCEPTION_STATUS;

import racingcar.exception.RacingCarIllegalArgumentException;

public class ReaderCannotReadException extends RacingCarIllegalArgumentException {

    public ReaderCannotReadException() {
        super(READER_CANNOT_READ_EXCEPTION_STATUS.getMessage());
    }

}
