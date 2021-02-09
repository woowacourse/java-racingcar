package racingcar.utils.exception;

import racingcar.view.ErrorView;

public class InvalidTextException extends RuntimeException {
    public InvalidTextException() {
        ErrorView.invalidText();
    }
}
