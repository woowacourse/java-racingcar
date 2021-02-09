package racingcar.utils.exception;

import racingcar.view.ErrorView;

public class InvalidNameLengthException extends RuntimeException {
    public InvalidNameLengthException(int max) {
        ErrorView.invalidNameLength(max);
    }
}
