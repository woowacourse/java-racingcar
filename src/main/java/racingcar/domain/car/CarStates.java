package racingcar.domain.car;

import java.util.List;

public class CarStates {
    private final List<CarState> carStates;

    private CarStates(List<CarState> carStates) {
        this.carStates = carStates;
    }

    public static CarStates valueOf(List<CarState> carStates) {
        return new CarStates(carStates);
    }

    public List<CarState> getCarStates() {
        return carStates;
    }
}