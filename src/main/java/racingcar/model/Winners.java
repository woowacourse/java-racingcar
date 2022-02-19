package racingcar.model;

import java.util.stream.Collectors;

public class Winners {

    private final Cars cars;

    public Winners(Cars cars) {
        this.cars = cars;
    }

    public String makeWinnerName(String delimiter) {
        return cars.getCarNames(delimiter);
    }
}
