package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<RacingCar> cars;

    public RacingGame(String input) {
        String[] carNames = input.split(",");
        this.cars = new ArrayList<>();
        for(String carName : carNames) {
            RacingCar car = new RacingCar(carName);
            this.cars.add(car);
        }
    }

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        for(RacingCar car : cars) {
            carNames.add(car.getName());
        }
        return carNames;
    }
}
