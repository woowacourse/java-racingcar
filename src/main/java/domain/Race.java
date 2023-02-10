package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final NumberPicker numberPicker;

    public Race(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            addNewCarWhenIsNotExists(carName, cars);
        }
        this.numberPicker = new RandomNumberPicker();
    }

    public Race(List<Car> cars, NumberPicker numberPicker) {
        this.cars = new ArrayList<>(cars);
        this.numberPicker = numberPicker;
    }

    public Race(Car[] cars) {
        this.cars = Arrays.asList(cars);
        this.numberPicker = new RandomNumberPicker();
    }

    private void addNewCarWhenIsNotExists(String carName, List<Car> cars) {
        Car car = new Car(carName);
        if (cars.contains(car)) {
            throw new IllegalArgumentException("자동차 이름은 중복일 수 없습니다.");
        }
        cars.add(car);
    }

    public void tryMoveOneTime() {
        for (Car car : cars) {
            car.moveDependingOn(numberPicker.pickNumber());
        }
    }

    public List<Car> getWinners() {
        Car winner = Collections.max(cars, Comparator.comparingInt(Car::getPosition));
        return cars.stream()
                .filter(car -> Comparator.comparingInt(Car::getPosition).compare(car, winner) == 0)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getStatuses() {
        return Collections.unmodifiableList(cars);
    }
}
