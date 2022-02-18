package racingcar.model;

import racingcar.utils.NameValidator;
import racingcar.utils.RandomForwardJudgment;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        NameValidator.isDuplicatedNames(carNames);
        this.cars = transformCarNamesToCars(carNames);
    }

    private List<Car> transformCarNamesToCars(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toUnmodifiableList());
    }

    public void forward() {
        for (Car car : cars) {
            car.forward(RandomForwardJudgment.canForward());
        }
    }

    public List<String> getWinnerNames() {
        int farthestPosition = getFarthestPosition();
        return cars.stream()
                .filter(car -> car.isSamePositionWith(farthestPosition))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private int getFarthestPosition() {
        if (cars.isEmpty()) {
            return 0;
        }

        return cars.stream()
                .max(Car::compareTo)
                .get()
                .getPosition();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
