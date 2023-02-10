package service;

import domain.Car;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

// TODO 전체적으로 빈줄 일관성 맞추기
public class RacingGame {

    private static final int POWER_VALUE_MIN = 0;
    private static final int POWER_VALUE_MAX = 9;
    private static final int PROCESS_MOVING_MIN_NUMBER = 4;

    private final NumberGenerator numberGenerator;
    private List<Car> cars;

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
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException("중복된 차량 이름이 존재합니다.");
        }
        if (carNames.size() == 1) {
            throw new IllegalArgumentException("차량이 둘 이상이어야 경주를 진행할 수 있습니다.");
        }

    }

    public void processAllCars() {
        for (Car car : cars) {
            int power = numberGenerator.generate(0, 9);
            process(car, power);
        }
    }

    private void process(Car car, int power) {
        validatePower(power);
        if (power >= PROCESS_MOVING_MIN_NUMBER) {
            car.move();
        }
    }

    private void validatePower(int power) {
        if (power < POWER_VALUE_MIN || power > POWER_VALUE_MAX) {
            throw new IllegalArgumentException("자동차 전진을 위한 값은 지정된 범위 내여야 합니다.");
        }
    }

    public List<String> decisionWinners() {
        List<String> winners = new ArrayList<>();
        int topPoint = cars.stream().mapToInt(Car::getPosition).max().getAsInt();
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
