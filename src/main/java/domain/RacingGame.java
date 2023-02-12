package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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
            int power = numberGenerator.generate(POWER_VALUE_MIN, POWER_VALUE_MAX);
            process(car, power);
        }
    }

    private void process(Car car, int power) {
        if (power >= PROCESS_MOVING_MIN_NUMBER) {
            car.move();
        }
    }

    public List<String> decisionWinners() {
        int topPoint = cars.stream().mapToInt(Car::getPosition).max().getAsInt();
        return cars.stream()
                .filter(car -> car.getPosition() == topPoint)
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
