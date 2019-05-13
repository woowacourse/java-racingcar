package game;

import game.output.ResultOutput;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int MAX_RANDOM_NUMBER = 10;

    public void playGame(List<Car> cars, int tryCount) {
        while (tryCount-- > 0) {
            playOneGame(cars);
            ResultOutput.printEachGame(cars);
        }
    }

    private void playOneGame(List<Car> cars) {
        for (Car car : cars) {
            car.move(randomValueGenerator());
        }
    }

    private int randomValueGenerator() {
        return (int) (Math.random() * MAX_RANDOM_NUMBER);
    }
}
