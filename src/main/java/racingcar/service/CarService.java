package racingcar.service;

import racingcar.model.Car;
import racingcar.model.CarDto;

import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    public Car toCar(CarDto carDto) {
        return new Car(carDto.getName());
    }

    public List<Car> toCars(List<CarDto> carDtos) {
        return carDtos.stream()
                .map(this::toCar)
                .collect(Collectors.toList());
    }
}
