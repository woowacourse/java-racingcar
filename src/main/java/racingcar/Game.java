package racingcar;

import racingcar.domain.Cars;
import racingcar.util.RandomNumberGenerator;

import java.util.HashMap;

public class Game {
    private HashMap<String, Integer> winners = new HashMap<String, Integer>();
    private Cars cars;

    public Game(Cars cars, int iteration) {
        this.cars = cars;
    }

    private void playGame(int iteration) {
        RandomNumberGenerator random = new RandomNumberGenerator();
        for (int i = 0; i < iteration; i++) {
            cars.playTurn(random);
        }
    }

    public HashMap<String, Integer> announceWinner() {
        winners.put("hiro", 6);
        return winners;
    }
}
