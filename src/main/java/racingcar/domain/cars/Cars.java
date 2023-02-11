package racingcar.domain.cars;

import racingcar.domain.car.Car;
import racingcar.domain.numbergenerator.NumberGenerator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private static final int MINIMUM_SIZE = 2;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> repository) {
        if (isOutOfSize(repository)) {
            throw new IllegalArgumentException("[ERROR] 자동차는 2대 이상 입력되어야 합니다.");
        }
        if (hasDuplication(repository)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }

    private boolean isOutOfSize(List<Car> repository) {
        return repository.size() < MINIMUM_SIZE;
    }

    private boolean hasDuplication(List<Car> repository) {
        return repository.stream()
                .distinct()
                .count() != repository.size();
    }

    public Map<String, Integer> moveBy(NumberGenerator numberGenerator) {
        Map<String, Integer> positionsByCar = new LinkedHashMap<>();
        for (Car car : cars) {
            car.move(numberGenerator.generate());
            positionsByCar.put(car.getName(), car.getPosition());
        }
        return positionsByCar;
    }
}
