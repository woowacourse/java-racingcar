package racingcar.dto;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

public class RacingGameDto {
    private final Cars cars;
    private final int numberOfRounds;
    private final int currentRound;

    public RacingGameDto(RacingGame racingGame) {
        this.cars = racingGame.getCars();
        this.numberOfRounds = racingGame.getNumberOfRounds();
        this.currentRound = racingGame.getCurrentRound();
    }

    public Cars getCars() {
        return cars;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getCurrentRound() {
        return currentRound;
    }
}
