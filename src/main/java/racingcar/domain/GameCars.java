package racingcar.domain;

import java.util.List;
import racingcar.util.Validator;

public class GameCars {

    private List<Car> cars;
    private List<String> winners;

    public GameCars(List<Car> cars, List<String> winners) {
        cars.forEach(car -> {
            Validator.validateCarName(car.getName().getName());
        });
        this.cars = cars;
        this.winners = winners;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        return winners;
    }

}
