package racingcar.model;

import java.util.*;

public class RacingGame {
    private static final String NUMBER_REGEX = "[1-9][0-9]*$";  // String matches에 사용할 숫자 REGEX 정의

    private Set<Car> cars = new LinkedHashSet<>();
    private int numberOfTry;

    public RacingGame(String[] carNames, String numberOfTry) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        if (this.isOverlap(carNames)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
        if (!numberOfTry.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("올바른 시도 횟수를 입력해야 합니다.");
        }
        this.numberOfTry = Integer.parseInt(numberOfTry);
    }

    /* 테스트를 위한 생성자 */
    public RacingGame(String[] carNames) {
        this(carNames, "0");
    }

    private boolean isOverlap(String[] carNames) {
        return this.cars.size() != carNames.length;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(Random.createRandomNumber());
        }
    }

    public WinningCars getWinnerCars() {
        return new WinningCars(this.cars);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.toString()).append("\n");
        }
        return stringBuilder.toString();
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
