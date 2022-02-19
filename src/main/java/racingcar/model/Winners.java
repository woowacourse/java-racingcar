package racingcar.model;

public class Winners {

    private final Cars cars;

    public Winners(Cars cars) {
        this.cars = cars;
    }

    public String makeWinnerName(String delimiter) {
        return cars.getCarNames(delimiter);
    }
}
