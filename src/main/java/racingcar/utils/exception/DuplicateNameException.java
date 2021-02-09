package racingcar.utils.exception;

import racingcar.view.ErrorView;

public class DuplicateNameException extends RuntimeException {
    public DuplicateNameException() {
        ErrorView.duplicateName();
    }
}
