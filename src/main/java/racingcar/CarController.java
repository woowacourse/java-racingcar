package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CarController {

    private final List<Car> cars = new ArrayList<>();

    public void run() {
        String carNames = InputView.getCarNames();
        int count = InputView.getCount();

    }
    public void add(Car car) {
        cars.add(car);
    }

    public List<Car> findWinners() {
        Car maxPositionCar = getMaxPositionCar();
        return cars.stream()
                .filter(car -> car.isSamePositionWith(maxPositionCar))
                .collect(toList());
    }

    private Car getMaxPositionCar() {
        cars.sort(Comparator.reverseOrder());
        return cars.get(0);
    }
}
