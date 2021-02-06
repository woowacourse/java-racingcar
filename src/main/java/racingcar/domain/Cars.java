package racingcar.domain;

import racingcar.dto.CarsResponseDto;
import racingcar.utils.RandomGenerator;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

//TODO
// 차 생성을 담당하는 로직을 cars로 위임하기
// validation을 cars에서 해주기 (쌩성자에서)

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

    public CarsResponseDto findWinners() {
        int maxPosition = getMaxPosition();
        return new CarsResponseDto(cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList()));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
