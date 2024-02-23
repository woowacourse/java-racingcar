package racingcar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.generator.NumberGenerator;

public class CarGroup {
    private final List<Car> cars;

    public CarGroup(List<Car> cars) {
        validateDuplicateNames(cars);
        this.cars = cars;
    }

    public int getCarsSize() {
        return cars.size();
    }

    private static void validateDuplicateNames(List<Car> cars) {
        int distinctNamesCount = (int) cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (distinctNamesCount != cars.size()) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }

    public MoveHistory race(NumberGenerator numberGenerator) {
        Map<String, Integer> nameAndPosition = new HashMap<>();
        List<Integer> carMoveValues = numberGenerator.generate(getCarsSize());
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            car.move(carMoveValues.get(i));
            nameAndPosition.put(car.getName(), car.getPosition());
        }

        return new MoveHistory(nameAndPosition);
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter((car -> car.isWinner(maxPosition)))
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
