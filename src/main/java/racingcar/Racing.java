package racingcar;

import java.util.Comparator;
import java.util.List;

public class Racing {

    public final List<Car> cars;
    private int gameCount;

    public Racing(List<Car> cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public void race() {
        while (isLeftRacing()) {
            gameCount--;
            raceAllCar();
        }
    }

    private boolean isLeftRacing() {
        return gameCount > 0;
    }

    private void raceAllCar() {
        cars.forEach(Car::race);
    }
}
