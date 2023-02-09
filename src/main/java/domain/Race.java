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
            cars.add(new Car(carName));
        }
        this.numberPicker = new RandomNumberPicker();
    }

    public Race(List<String> carNames, NumberPicker numberPicker) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.numberPicker = numberPicker;
    }

    //ToDo : 시간 남았을 때 테스트 해보기
    public void tryMoveOneTime() {
        for (Car car : cars) {
            car.moveDependingOn(numberPicker.pickNumber());
        }
    }

    public List<Car> judgeWinners() {
        Car c = Collections.max(cars);
        return cars.stream()
                .filter(car -> car.compareTo(c) >= 0)
                .collect(Collectors.toList());
    }

    public List<CarDTO> getCarDTOs() {
        return cars.stream().map(Car::toDTO).collect(Collectors.toList());
    }
}
