package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.utils.NumberGenerator;
import racingcar.model.utils.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void participateInRacing(Car car) {
        this.cars.add(car);
    }

    public void race(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator);
        }
    }

    public List<Name> judgeRacingWinners() {
        Car maxPositionCar = getMaxPositionCar();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car getMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new RuntimeException("차량이 존재하지 않습니다"));
    }

    public List<Car> getParticipantCars() {
        return Collections.unmodifiableList(cars);
    }
}
