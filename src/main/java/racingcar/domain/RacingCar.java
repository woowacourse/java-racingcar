package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCar {
    private List<Car> cars;

    public RacingCar() {
        cars = new ArrayList<>();
    }

    public List<Car> prepareRace(String userInput) {
        String[] carNames = makeCarNames(userInput);
        setCars(carNames);
        return cars;
    }

    private String[] makeCarNames(String userInput) {
        return userInput.split(",");
    }

    private void setCars(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    public void playOneRound() {
        for (Car car : cars) {
            car.play();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> sb.append(car + "\n"));
        return sb.toString();
    }
}
