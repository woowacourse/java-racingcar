package racinggame;

import racinggame.view.resultOutput;

import java.util.List;

public class Game {

    private static final int MAX_RANDOM_VALUE = 9;

    public Winner playGames(List<Car> cars, int maxInstance) {
        Winner winner = new Winner();

        while (!winner.checkWinner(cars, maxInstance)) {
            playOneGame(cars);
        }
        return winner;
    }

    private void playOneGame(List<Car> cars) {
        for (Car car : cars) {
            car.move(randomValueGenerator());
            resultOutput.eachGameOutput(car);
        }
        resultOutput.printNewLine();
    }

    private int randomValueGenerator() {
        return ((int) (Math.random() * MAX_RANDOM_VALUE)) + 1;
    }
}
