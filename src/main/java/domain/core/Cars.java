package domain.core;

import domain.vo.Distance;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarNameDuplicate(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateCarNameDuplicate(List<Car> cars) {
        List<String> filtered = cars.stream()
                .map(Car::name)
                .distinct()
                .collect(Collectors.toList());

        if (cars.size() != filtered.size()) {
            throw new IllegalArgumentException("자동차 이름에 중복이 존재합니다.");
        }
    }

    public List<Car> playOnce(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            int randomNumber = numberGenerator.generate();
            car.move(randomNumber);
        }
        return cars;
    }

    public List<Car> winners() {
        int maximumDistance = cars.stream()
                .mapToInt(Car::distance)
                .max().getAsInt();

        Distance criteria = new Distance(maximumDistance);

        return cars.stream()
                .filter(car -> car.isSameDistance(criteria))
                .collect(Collectors.toList());
    }

    public List<Car> cars() {
        return List.copyOf(cars);
    }
}
