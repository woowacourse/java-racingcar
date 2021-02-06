package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.view.OutputView;

public class RacingCarGame {
    private final Cars cars;
    private final Round Round;

    private RacingCarGame(Cars cars, Round round) {
        this.cars = cars;
        this.Round = round;
    }

    public static RacingCarGame createNewGame(Cars cars, Round round) {
        return new RacingCarGame(cars, round);
    }

    public void play() {
        // TODO 실행 결과 출력
        while (!Round.isEnd()) {
            cars.moveCars();
            OutputView.printCarsPosition(cars.toDTO());
            Round.nextRound();
        }

        // TODO 우승자 출력
    }
}
