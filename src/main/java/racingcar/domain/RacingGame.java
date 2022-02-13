package racingcar.domain;

import java.util.List;

import static racingcar.constants.SystemConstants.NUMBER_ONE_FOR_INCREMENT;
import static racingcar.constants.GameConstants.INITIAL_ROUND_NUM;

public class RacingGame {

    private final Cars cars = new Cars();
    private final int totalRounds;
    private int currentRound = INITIAL_ROUND_NUM;

    public RacingGame(String[] carNames, int totalRounds) {
        initCars(carNames);
        this.totalRounds = totalRounds;
    }

    private void initCars(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars.findAllCars();
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }

    public void playRound() {
        cars.race();
        addOneRound();
    }

    private void addOneRound() {
        currentRound += NUMBER_ONE_FOR_INCREMENT;
    }


    public boolean isOver() {
        return currentRound >= totalRounds;
    }
}
