package racingcar.domain;

import static racingcar.constants.GameConstants.INITIAL_ROUND_NUM;
import static racingcar.constants.SystemConstants.NUMBER_ONE_FOR_INCREMENT;
import static racingcar.util.ValidatorUtils.validatePositiveInt;

import java.util.List;
import java.util.Objects;

public class RacingGame {

    private final Cars cars;
    private final int totalRounds;
    private int currentRound = INITIAL_ROUND_NUM;

    public RacingGame(String[] carNames, int totalRounds) {
        validatePositiveInt(totalRounds);

        cars = new Cars(carNames);
        this.totalRounds = totalRounds;
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
        return cars.findWinners();
    }

    @Override
    public String toString() {
        return "RacingGame{" +
                "cars=" + cars +
                ", totalRounds=" + totalRounds +
                ", currentRound=" + currentRound +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingGame that = (RacingGame) o;
        return totalRounds == that.totalRounds
                && currentRound == that.currentRound
                && Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, totalRounds, currentRound);
    }
}
