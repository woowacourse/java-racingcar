package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.RandomNumberGenerator;

import java.util.HashMap;
import java.util.List;

import static racingcar.Utils.checkMove;

public class Game {
    private HashMap<String, Integer> winners = new HashMap<String, Integer>();
    private Cars cars;

    public Game(Cars cars, int iteration) {
        this.cars = cars;
        playGame(iteration);
    }

    private void playGame(int iteration) {
        for (int i = 0; i < iteration; i++) {
            cars.playTurn();
        }
    }

    public HashMap<String, Integer> announceWinner() {
        winners.put("hiro", 6);
        return winners;
    }
}
