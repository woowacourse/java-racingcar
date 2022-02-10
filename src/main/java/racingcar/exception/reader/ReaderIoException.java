package racingcar.exception.reader;

import racingcar.exception.RacingCarException;

public class ReaderIoException extends RacingCarException {

	public ReaderIoException() {
		super("입력을 받아올 수 없습니다.");
	}

}
