package racingcar;

import racingcar.domain.Cars;
import racingcar.io.ConsoleOutput;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
            ConsoleOutput.printStatus(cars.notifyStatus());
        }
        ConsoleOutput.printResult(findWinner(cars.notifyStatus()));
    }

    public List<String> findWinner(LinkedHashMap<String, Integer> finalStatus) {
        List<String> winners = new ArrayList<>();
        int maxValue = findMaxPosition(finalStatus);
        for (String name : finalStatus.keySet()) {
            if (finalStatus.get(name).equals(maxValue)) {
                winners.add(name);
            }
        }
        return winners;
    }

    private int findMaxPosition(LinkedHashMap<String, Integer> finalStatus) {
        int maxValue = 0;
        for (Map.Entry<String, Integer> entry : finalStatus.entrySet()) {
            Integer position = entry.getValue();
            if (maxValue < position) {
                maxValue = position;
            }
        }
        return maxValue;
    }
}
