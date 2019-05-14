package racingcar.model;

import java.util.*;

public class RacingGame {
    private static final int MIN_NUMBER_OF_TRY = 0;
    private Set<Car> cars = new LinkedHashSet<>();
    private int numberOfTry;
    private StringBuilder savedResult = new StringBuilder();

    public RacingGame(String[] carNames, int numberOfTry) {
        if (this.isOverlap(carNames)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
        if (numberOfTry < MIN_NUMBER_OF_TRY) {
            throw new IllegalArgumentException("올바른 시도 횟수를 입력해야 합니다.");
        }
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.numberOfTry = numberOfTry;
    }

    public RacingGame(String[] carNames) {
        this(carNames, 0);
    }

    private boolean isOverlap(String[] carNames) {
        return new HashSet<>(Arrays.asList(carNames)).size() != carNames.length;
    }

    public void playGame() {
        while (this.numberOfTry-- > 0) {
            this.moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(Random.createRandomNumber());
            savedResult.append(car.toString()).append("\n");
        }
        savedResult.append("\n");
    }

    public String result() {
        return savedResult.toString();
    }

    public WinningCars getWinnerCars() {
        return new WinningCars(this.cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return numberOfTry == that.numberOfTry &&
                Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, numberOfTry);
    }
}
