package racingcargame.domain;

import racingcargame.controller.CarDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

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

    public CarDto processOneRace(MoveDecider moveDecider) {
        cars.forEach(car -> car.decideGoOrStop(moveDecider));
        return new CarDto(cars);
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
