package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.Converter;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNames) {
        this.cars = Converter.stringToCars(carNames);
    }

    public List<String> getWinnerNames() {
        final Car maxPositionCar = findMaxPositionCar();
        return findSamePositionCars(maxPositionCar);
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차량 리스트가 비었습니다."));
    }

    private List<String> findSamePositionCars(Car maxPositionCar) {
        return cars.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void moveCars(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
