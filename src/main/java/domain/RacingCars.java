package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> racingCars = new ArrayList<>();

    public RacingCars(List<String> carNames) {
        addCars(carNames);
    }

    private void addCars(final List<String> carNames) {
        validateCarNames(carNames);
        carNames.forEach(name -> racingCars.add(new Car(name)));
    }

    private void validateCarNames(final List<String> carNames) {
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException("중복된 차량 이름이 존재합니다.");
        }
        if (carNames.size() == 1) {
            throw new IllegalArgumentException("차량이 둘 이상이어야 경주를 진행할 수 있습니다.");
        }
    }

    public void process(final NumberGenerator powerValueGenerator) {
        racingCars.forEach(car -> car.moveOrStayByPower(powerValueGenerator.generate()));
    }

    public List<String> findHeadCarNames() {
        final List<Car> sortedCars = new ArrayList<>(racingCars);
        sortedCars.sort(Collections.reverseOrder());
        return racingCars.stream()
                .filter(car -> car.compareTo(sortedCars.get(0)) == 0)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> racingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
