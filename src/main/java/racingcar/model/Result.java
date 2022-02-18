package racingcar.model;

import java.util.List;

public class Result {
    private final WinnerCars winnerCars;

    public Result(List<Car> cars, int maxPosition) {
        this.winnerCars = new WinnerCars(cars, maxPosition);
    }

    public WinnerCars getWinners() {
        return winnerCars;
    }
}
