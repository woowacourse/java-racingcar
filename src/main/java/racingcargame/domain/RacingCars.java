package racingcargame.domain;

import racingcargame.controller.CarDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int NUMBER_RANGE = 10;
    private static final String DELIMITER = ",";

    private List<Car> cars;

    public RacingCars(String names) {
        this.cars = setCars(names);
    }

    private List<Car> setCars(String names) {
        cars = new ArrayList<>();
        String[] carNames = splitName(names);

        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private String[] splitName(String userInput) {
        return userInput.split(DELIMITER);
    }

    public CarDto processOneRace() {
        cars.forEach(car -> car.decideGoOrStop(createRandomNumber()));
        return new CarDto(cars);
    }

    private int createRandomNumber() {
        return (int) (Math.random() * NUMBER_RANGE);
    }

    public String getWinner() {
        Collections.sort(cars);
        int maxPosition = cars.get(0).getCarPosition();

        List<String> winnerCar = cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(Car::getCarName)
                .collect(Collectors.toList());
        return String.join(DELIMITER, winnerCar);
    }
}
