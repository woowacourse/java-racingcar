package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Lap;
import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingMain {
    public static void main(String[] args) {
        Cars cars = createRacingCars();
        Lap lap = createLap();
        RacingCarGame racingCarGame = new RacingCarGame(cars, lap);

        while (!racingCarGame.isEnd()) {
            OutputView.showResultMessage();
            racingCarGame.race();
            OutputView.showOneLapResult(racingCarGame.getResult());
        }
        OutputView.showWinners(racingCarGame.getWinners());
    }

    private static Lap createLap() {
        try {
            return new Lap(InputView.getLapInput());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createLap();
        }
    }

    private static Cars createRacingCars() {
        try {
            return InputView.getCarNamesInput();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createRacingCars();
        }
    }
}
