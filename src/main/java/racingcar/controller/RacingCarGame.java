package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Round;

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
            // TODO 자동차 현 위치 출력
            Round.nextRound();
        }

        // TODO 우승자 출력
    }
}
