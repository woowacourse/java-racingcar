package racingcar.utils.exception;

import racingcar.view.ErrorView;

public class NotEnoughCarException extends RuntimeException {
    public NotEnoughCarException(int number) {
        ErrorView.notEnoughCar(number);
    }
}
