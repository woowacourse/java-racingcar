package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

import java.util.List;
import java.util.Objects;

public class RacingGame {
    private final Cars cars;
    private final Round numberOfRounds;
    private final Round currentRound;

    public RacingGame(Cars cars, Round numberOfRounds) {
        this.cars = cars;
        this.numberOfRounds = numberOfRounds;
        this.currentRound = new Round();
    }

    public void playAnotherRound() {
        cars.moveCars(new RandomNumberGenerator());
        currentRound.increase();
    }

    public boolean isFinished() {
        return currentRound.equals(numberOfRounds);
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }

    public Cars getCars() {
        return cars.copy();
    }

    public int getNumberOfRoundsAsInt() {
        return numberOfRounds.getRound();
    }

    public int getCurrentRoundAsInt() {
        return currentRound.getRound();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return cars.equals(that.cars) && numberOfRounds.equals(that.numberOfRounds) && currentRound.equals(that.currentRound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, numberOfRounds, currentRound);
    }
}