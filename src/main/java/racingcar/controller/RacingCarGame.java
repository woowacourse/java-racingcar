package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.domain.Winners;
import racingcar.view.OutputView;

/**
 * RacingCarGame.java
 * 경주가 진행되는 도중의 로직을 관장하는 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class RacingCarGame {
    private final Cars cars;
    private final Round round;

    private RacingCarGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public static RacingCarGame createNewGame(Cars cars, Round round) {
        return new RacingCarGame(cars, round);
    }

    public void play() {
        OutputView.printResultMessage();

        while (!round.isEnd()) {
            cars.moveCars();
            OutputView.printCarsPosition(cars.toDTO());
            round.nextRound();
        }

        Winners winners = Winners.of(cars);
        OutputView.printWinners(winners.toListOfNames());
    }
}
