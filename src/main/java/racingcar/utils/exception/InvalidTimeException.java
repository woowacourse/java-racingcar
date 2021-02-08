package racingcar.utils.exception;

import racingcar.view.ErrorView;

public class InvalidTimeException extends RuntimeException {
    public InvalidTimeException() {
        ErrorView.invalidTime();
    }
}
