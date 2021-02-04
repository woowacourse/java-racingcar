package racingcar.domain;

import racingcar.dto.CarsResponseDto;
import racingcar.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private int round;

    private final int INIT_ROUND = 1;

    public RacingGame() {
        this.round = INIT_ROUND;
    }

    public void makeCars(List<String> names) {
        names.forEach(name -> addCar(new Car(name)));
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void playRound() {
        cars.forEach(car -> car.move(RandomGenerator.generateRandomNumber()));
        round++;
    }

    public String decideWinner() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
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

    public int getRound() {
        return round;
    }
}
