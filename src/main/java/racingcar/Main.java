package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.car.Car;
import racingcar.domain.result.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String carsName = InputView.inputCarNames();
        String roundNumber = InputView.inputRound();

        RacingGame racingGame = new RacingGame(carsName, roundNumber);
        RacingResult racingResult = racingGame.play();
        OutputView.printResult(racingResult);

        List<Car> winners = racingResult.getWinners();
        OutputView.printWinners(winners);
    }
}
