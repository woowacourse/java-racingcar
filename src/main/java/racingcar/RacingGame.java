package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final String CAR_NAME_DELIMITER = ",";
    private final List<RacingCar> cars;
    private int leftCount;
    private final RandomGenerator generator = new RandomGenerator();

    public RacingGame(String carStringNames, int leftCount) {
        this.cars = makeRacingCars(carStringNames.split(CAR_NAME_DELIMITER));
        checkPositiveCount(leftCount);
        this.leftCount = leftCount;
    }

    private List<RacingCar> makeRacingCars(String[] carNames) {
        return Arrays.stream(carNames)
            .map(RacingCar::new)
            .collect(Collectors.toList());
    }

    private void checkPositiveCount(int leftCount) {
        if (leftCount <= 0) {
            throw new IllegalArgumentException("시도횟수는 0이하의 값이 들어올 수 없다.");
        }
    }

    public List<String> getCarNames() {
        return cars.stream()
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }

    public int getLeftCount() {
        return leftCount;
    }

    public void race() {
        checkCanRace();
        while (!isEnd()) {
            moveCars();
        }
    }

    private void checkCanRace() {
        if (isEnd()) {
            throw new RuntimeException("종료된 게임은 더이상 실행할 수 없다.");
        }
    }

    private void moveCars() {
        cars.forEach(this::moveCar);
        leftCount--;
    }

    private void moveCar(RacingCar car) {
        if (generator.isMovable()) {
            car.move();
        }
    }

    public boolean isEnd() {
        return leftCount == 0;
    }
}
