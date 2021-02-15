package racingcar.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private static final int MINIMUM_CAR_AMOUNT = 2;
    private static final int START = 0;
    private static final int END = 9;

    private List<Car> cars;

    public Cars(List<String> splitCarNames) {
        List<Car> cars = splitCarNames.stream()
            .map(carName -> new Car(carName))
            .collect(Collectors.toList());
        validateNumberOfCar(splitCarNames);
        validateSameName(splitCarNames);
        this.cars = cars;
    }

    public void raceOneLap(List<Integer> randoms) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(randoms.get(i));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        int maxDistance = getMaxDistance();
        return cars.stream()
            .filter(car -> car.isMaxPosition(maxDistance))
            .map(Car::getCarName)
            .collect(Collectors.toList());
    }

    public int getCarsCount() {
        return cars.size();
    }

    private int getMaxDistance() {
        return cars.stream()
            .collect(Collectors.summarizingInt(Car::getPosition))
            .getMax();
    }

    private void validateNumberOfCar(List<String> carNamesInput) {
        if (carNamesInput.size() < MINIMUM_CAR_AMOUNT) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }

    private void validateSameName(List<String> carNamesInput) {
        Set<String> uniqueCarNames = new HashSet<>(carNamesInput);
        if (uniqueCarNames.size() != carNamesInput.size()) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 있습니다.");
        }
    }

}
