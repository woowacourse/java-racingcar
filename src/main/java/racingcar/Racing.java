package racingcar;

import java.util.List;

public class Racing {

    public final List<Car> cars;
    private int gameCount;

    public Racing(List<Car> cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public void race() {
        System.out.println("실행 결과");
        while (isLeftRacing()) {
            gameCount--;
            raceAllCar();
            printCurrentRaceResult();
        }
    }

    private boolean isLeftRacing() {
        return gameCount > 0;
    }

    private void raceAllCar() {
        cars.forEach(Car::race);
    }

    private void printCurrentRaceResult() {
        cars.forEach(Car::printCurrentPosition);
        System.out.println();
    }
}
