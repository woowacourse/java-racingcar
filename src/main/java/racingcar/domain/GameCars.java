package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameCars {

    private List<Car> cars;
    private List<String> winners;

    public GameCars() {
        this.cars = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        return winners;
    }

}
