package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public interface OutputView {
    public void printCarPosition(final Cars cars);
    public void printWinners(final List<Car> winners);
    public void printResultMsg();
    default void printErrorMsg(String errorMsg) {
        System.out.println(errorMsg);
    }
}
