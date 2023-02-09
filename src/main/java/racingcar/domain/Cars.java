package racingcar.domain;

import racingcar.constant.ErrorLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    private final int FIRST_INDEX = 0;

    public void add(Car car) {
        cars.add(car);
    }

    public void addNextCarValue(int value) {

        int size = cars.get(FIRST_INDEX).getLogSize();

        Optional<Car> targetCar = cars.stream().filter(car -> car.getLogSize() < size)
                .findFirst();

        if (isRoundOver()) {
            cars.get(FIRST_INDEX).addValue(value);
            return;
        }
        getCurrentTurnCar().get().addValue(value);
    }

    private boolean isRoundOver() {
        return getCurrentTurnCar().isEmpty();

    }

    private Optional<Car> getCurrentTurnCar() {
        int size = cars.get(FIRST_INDEX).getLogSize();
        Optional<Car> targetCar = cars.stream().filter(car -> car.getLogSize() < size)
                .findFirst();

        return targetCar;
    }

    public int getTurnCount() {
        if (!isRoundOver()) {
            throw new IllegalStateException(ErrorLog.ROUND_NOT_OVER.getMessage());
        }
        return cars.get(FIRST_INDEX).getLogSize();
    }


}
