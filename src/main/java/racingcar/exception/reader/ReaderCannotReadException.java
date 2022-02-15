package racingcar.exception.reader;

import racingcar.exception.RacingCarException;
import racingcar.exception.reader.message.ReaderExceptionMessage;

public class ReaderCannotReadException extends RacingCarException {

    public ReaderCannotReadException() {
        super(ReaderExceptionMessage.READER_CANNOT_READ.getMessage());
    }

}
