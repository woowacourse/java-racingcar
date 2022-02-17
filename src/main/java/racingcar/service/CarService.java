package racingcar.service;

import racingcar.model.Car;
import racingcar.model.CarDto;
import racingcar.model.CarRepository;
import racingcar.model.RandomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private final CarRepository carRepository;

    public CarService() {
        this.carRepository = new CarRepository();
    }

    public Car toCar(CarDto carDto) {
        return new Car(carDto.getName());
    }

    public List<Car> toCars(List<CarDto> carDtos) {
        return carDtos.stream()
                .map(this::toCar)
                .collect(Collectors.toList());
    }

    public void createCars(List<Car> cars) {
        cars.forEach(carRepository::save);
    }

    public List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < carRepository.getSize(); i++) {
            randomNumbers.add(RandomNumber.getNumber());
        }
        return randomNumbers;
    }
}
