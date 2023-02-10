package domain;

import java.util.ArrayList;
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

    public Race(List<String> carNames, List<Integer> carPositions) {
        cars = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            cars.add(new Car(carNames.get(i), carPositions.get(i)));
        }
        this.numberPicker = new RandomNumberPicker();
    }

    private void addNewCarWhenIsNotExists(String carName, List<Car> cars) {
        Car car = new Car(carName);
        if (cars.contains(car)) {
            throw new IllegalArgumentException("자동차 이름은 중복일 수 없습니다.");
        }
        cars.add(car);
    }

    //ToDo : 시간 남았을 때 테스트 해보기
    public void tryMoveOneTime() {
        for (Car car : cars) {
            car.moveDependingOn(numberPicker.pickNumber());
        }
    }

    public List<CarDto> getWinners() {
        Car winner = Collections.max(cars, Comparator.comparingInt(Car::getPosition));
        return cars.stream()
                .filter(car -> Comparator.comparingInt(Car::getPosition).compare(car, winner) == 0)
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CarDto> getCarDtos() {
        return cars.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toUnmodifiableList());
    }
}
