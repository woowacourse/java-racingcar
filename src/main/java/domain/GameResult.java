package domain;

import utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameResult {
    private List<Car> cars;
    private int gameRound;

    public GameResult(List<String> names, int gameRound) {
        cars = new ArrayList<>();
        this.gameRound = gameRound;

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void raceByRound() {
        for (Car car : cars) {
            car.move(RandomUtil.randomNumber());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getGameRound() {
        return gameRound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return gameRound == that.gameRound &&
                Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, gameRound);
    }
}
