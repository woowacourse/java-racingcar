package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public interface OutputView {
    void printResultMessage();
    void printRoundStatus(List<Car> cars);
}
