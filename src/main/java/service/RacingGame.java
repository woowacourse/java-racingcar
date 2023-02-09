package service;

import domain.Car;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class RacingGame {
    private static final int RANDOM_START_INCLUSIVE = 0;
    private static final int RANDOM_END_INCLUSIVE = 9;
    private static final int PROCESS_MOVING_MIN_NUMBER = 4;

    private List<Car> cars;
    private NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator) {
        this.cars = new ArrayList<>();
        this.numberGenerator = numberGenerator;
    }

    public void generateCars(List<String> carNames) {
        validateCarNames(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void validateCarNames(List<String> carNames) {
        if (Objects.isNull(carNames)) {
            throw new IllegalStateException("차량 이름 Null 에러");
        }
        validateDuplicateCarName(carNames);
        validateCarNumberThanMin(carNames);
    }

    private void validateDuplicateCarName(List<String> carNames) {
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException("중복된 차량 이름이 존재합니다.");
        }
    }

    private void validateCarNumberThanMin(List<String> carNames) {
        if (carNames.size() == 1) {
            throw new IllegalArgumentException("차량이 둘 이상이어야 경주를 진행할 수 있습니다.");
        }
    }

    public void processAllCars() {
        for (Car car : cars) {
            int random = numberGenerator.generate(0, 9);
            process(car, random);
        }
    }

    private void process(Car car, int value) {
        validateProcessValue(value);
        if (value >= PROCESS_MOVING_MIN_NUMBER) {
            car.move();
        }
    }

    private void validateProcessValue(int value) {
        if (value < RANDOM_START_INCLUSIVE || value > RANDOM_END_INCLUSIVE) {
            throw new IllegalArgumentException("자동차 전진을 위한 값은 지정된 범위 내여야 합니다.");
        }
    }

    public List<String> decisionWinners() {
        List<String> winners = new ArrayList<>();
        int topPoint = cars.stream().mapToInt(c -> c.getPosition()).max().getAsInt();
        for (Car car : cars) {
            addWinners(winners, topPoint, car);
        }
        return Collections.unmodifiableList(winners);
    }

    private void addWinners(List<String> winners, int topPoint, Car car) {
        if (car.getPosition() == topPoint) {
            winners.add(car.getName());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
