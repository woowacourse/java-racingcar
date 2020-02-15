package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.Round;
import racingcar.domain.Winners;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.result.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputForCarNames = InputView.inputCarNames();
        List<Car> cars = Cars.generateCarsByInput(inputForCarNames);

        String inputForRound = InputView.inputRound();
        Round round = new Round(inputForRound);

        RacingGame racingGame = new RacingGame(cars, round);
        RacingResult racingResult = racingGame.play();
        OutputView.printResult(racingResult);

        List<Car> winners = Winners.getWinners(cars);
        OutputView.printWinners(winners);
    }
}
