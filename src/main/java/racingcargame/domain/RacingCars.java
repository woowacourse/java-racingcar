package racingcargame.domain;

import racingcargame.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int NUMBER_RANGE = 10;
    private static final String DELIMITER = ",";

    private List<Car> cars;

    public RacingCars(String userInput) {
        this.cars = setCars(userInput);
    }

    private List<Car> setCars(String userInput) {
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

    public void processOneTime() {
        for (Car car : cars) {
            car.decideGoOrStop(createRandomNumber());
            OutputView.carNameAndPosition(car);
        }
    }

    private int createRandomNumber() {
        return (int) (Math.random() * NUMBER_RANGE);
    }

    public String getWinner() {
        Collections.sort(cars);
        int maxPosition = cars.get(0).getCarPosition();

        List<String> winnerCar = cars.stream()
                .filter(car -> car.getCarPosition() == maxPosition)
                .map(car -> car.getCarName())
                .collect(Collectors.toList());
        return String.join(", ", winnerCar);
    }
}
