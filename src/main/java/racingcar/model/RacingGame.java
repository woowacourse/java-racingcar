package racingcar.model;

import java.util.*;

public class RacingGame {
    private static final int END_TRY_NUMBER = 0;

    private Set<Car> cars = new LinkedHashSet<>();
    private int numberOfTry;

    public RacingGame(String[] carNames, int numberOfTry) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.numberOfTry = numberOfTry;
        if (this.isOverlap(carNames)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public boolean checkNumberOfTry() {
        numberOfTry--;
        return numberOfTry >= END_TRY_NUMBER;
    }

    private boolean isOverlap(String[] carNames) {
        return carNames.length != cars.size();
    }

    public boolean isEqualCars(Set<Car> cars) {
        return this.cars.toString().equals(cars.toString());
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(Random.createRandomNumber());
        }
    }

    public WinningCars getWinnerCars() {
        WinningCars winningCars = new WinningCars();
        winningCars.setWinner(cars);
        return winningCars;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString()).append("\n");
        }
        return sb.toString();
    }

}
