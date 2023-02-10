package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private final NumberPicker numberPicker;

    public Race(List<String> carNames) {
        for (String carName : carNames) {
            addNewCarBy(carName);
        }
        this.numberPicker = new RandomNumberPicker();
    }

    public Race(List<String> carNames, NumberPicker numberPicker) {
        for (String carName : carNames) {
            addNewCarBy(carName);
        }
        this.numberPicker = numberPicker;
    }

    private void addNewCarBy(String carName) {
        Car car = new Car(carName);
        if (carWithSameNameAlreadyExists(car)) {
            throw new IllegalArgumentException("자동차 이름은 중복일 수 없습니다.");
        }
        cars.add(car);
    }

    private boolean carWithSameNameAlreadyExists(Car car) {
        return cars.contains(car);
    }

    //ToDo : 시간 남았을 때 테스트 해보기
    public void tryMoveOneTime() {
        for (Car car : cars) {
            car.moveDependingOn(numberPicker.pickNumber());
        }
    }

    public List<CarDto> judgeWinners() {
        Car c = Collections.max(cars, Car.positionComparator);
        return cars.stream()
                .filter(car -> Car.positionComparator.compare(car, c) == 0)
                .map(Car::toDTO)
                .collect(Collectors.toList());
    }

    public List<CarDto> getCarDTOs() {
        return cars.stream().map(Car::toDTO).collect(Collectors.toList());
    }
}
