package racingcargame.domain;

import racingcargame.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Cars cars;
    private int raceCount;

    public Game(String input, int count) {
        String[] carNames = input.split(",");
        cars = new Cars(makeCars(carNames));
        this.raceCount = count;
    }

    public void race() {
        cars.race();
        raceCount--;
    }

    public boolean hasRaceCount() {
        return raceCount != 0;
    }

    public List<Car> makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public Cars getCars() {
        return cars;
    }
}
