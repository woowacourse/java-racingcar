package racingcar.domain;

import static racingcar.constants.GameConstants.INITIAL_ROUND_NUM;
import static racingcar.constants.SystemConstants.NUMBER_ONE_FOR_INCREMENT;
import static racingcar.util.ValidatorUtils.validateNoDuplicates;
import static racingcar.util.ValidatorUtils.validatePositiveInt;

import java.util.List;

public class RacingGame {

    private final Cars cars = new Cars();
    private final int totalRounds;
    private int currentRound = INITIAL_ROUND_NUM;

    public RacingGame(String[] carNames, int totalRounds) {
        validateNoDuplicates(carNames);
        validatePositiveInt(totalRounds);

        initCars(carNames);
        this.totalRounds = totalRounds;
    }

    private void initCars(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
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

    public List<Car> getCars() {
        return cars.findAllCars();
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }

    @Override
    public String toString() {
        return "RacingGame{" +
                "cars=" + cars +
                ", totalRounds=" + totalRounds +
                ", currentRound=" + currentRound +
                '}';
    }
}
