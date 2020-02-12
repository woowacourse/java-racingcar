package racingcar;

import racingcar.domain.Cars;
import racingcar.io.consoleOutput;
import racingcar.util.RandomNumberGenerator;

import java.util.*;

public class Game {

    private final int iteration;
    private Cars cars;

    public Game(Cars cars, int iteration) {
        this.cars = cars;
        this.iteration = iteration;
    }

    public void playGame() {
        RandomNumberGenerator random = new RandomNumberGenerator();
        for (int i = 0; i < iteration; i++) {
            cars.playTurn(random);
            consoleOutput.printStatus(cars.notifyStatus());
        }
        consoleOutput.printResult(findWinner(cars.notifyStatus()));
    }

    public List<String> findWinner(LinkedHashMap<String, Integer> finalStatus) {
        int maxValue = 0;
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : finalStatus.entrySet()) {
            String name = entry.getKey();
            Integer position = entry.getValue();
            if (maxValue < position) {
                maxValue = position;
            }
        }
        for(String name : finalStatus.keySet()) {
            if(finalStatus.get(name).equals(maxValue)) {
                winners.add(name);
            }
        }
        return winners;
    }
}
