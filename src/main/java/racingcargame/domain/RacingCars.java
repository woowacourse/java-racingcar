package racingcargame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int NUMBER_RANGE = 10;
    private static final String DELIMITER = ",";

    private List<Car> cars;

    public RacingCars(String userInput) {
        this.cars = carsNameSettingFinished(userInput);
    }

    private List<Car> carsNameSettingFinished(String userInput) {
        cars = new ArrayList<>();
        String[] carNames = splitName(userInput);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private String[] splitName(String userInput) {
        return userInput.split(DELIMITER);
    }

    public EachRaceResultDto processOneRace() {
        for (Car car : cars) {
            car.decideGoOrStop(createRandomNumber());
        }
        return new EachRaceResultDto(cars);
    }

    private int createRandomNumber() {
        return (int) (Math.random() * NUMBER_RANGE);
    }

    public List<Car> getWinners() {
        Collections.sort(cars);
        int maxPosition = cars.get(0).getCarPosition();

        List<Car> winnerCar = cars.stream()
                .filter(car -> car.getCarPosition() == maxPosition)
                .collect(Collectors.toList());
        return winnerCar;
    }
}
