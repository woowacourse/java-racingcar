package racingcargame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    private List<Car> makeCars(String[] carNames) {
        return Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }

    public Cars Cars() {
        return cars;
    }

    public List<Car> Winners() {
        return cars.findWinners();
    }
}
