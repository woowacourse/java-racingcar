package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.GameCount;
import racingcar.domain.RacingGame;
import racingcar.domain.result.RacingGameResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = InputView.getCars();
        GameCount gameCount = InputView.getGameCount();
        RacingGameResult racingGameResult = new RacingGame(cars, gameCount).start();
        OutputView.showRacingGameResult(racingGameResult);
        OutputView.showWinners(racingGameResult);
    }
}
