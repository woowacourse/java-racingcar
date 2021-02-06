package racingcar.domain;

import racingcar.dto.CarsResponseDto;
import racingcar.utils.RandomGenerator;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

//TODO
// validation을 cars에서 해주기 (쌩성자에서)
// getMaxPosition말고 메세지를 보내는 쪽으로 해보자

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = createCars(names);
    }

    public List<Car> createCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars() {
        cars.forEach(car -> car.move(RandomGenerator.generateRandomNumber()));
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public CarsResponseDto getCarsResponseDto() {
        return new CarsResponseDto(cars);
    }

    public static CarsResponseDto getCarsResponseDto(List<Car> cars) {
        return new CarsResponseDto(cars);
    }
}
