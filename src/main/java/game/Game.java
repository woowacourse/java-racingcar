package game;

import java.util.List;

public class Game {
    private static final int MAX_RANDOM_NUMBER = 10;

    public void playOneGame(List<Car> cars) {
        for (Car car : cars) {
            car.move(randomValueGenerator());
        }
    }

    private int randomValueGenerator() {
        return (int) (Math.random() * MAX_RANDOM_NUMBER);
    }
}
