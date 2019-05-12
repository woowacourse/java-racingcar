package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    public static void main(String[] args) {
        String userInput = InputView.getUserCarNames();
        RacingCar racingCar = new RacingCar();
        List<Car> cars = racingCar.prepareRace(userInput);

        int numOfGame = InputView.getNumberOfGame();
        playGame(racingCar, numOfGame);

        RacingResult.process(cars);
    }

    private static void playGame(RacingCar racingCar, int numOfGame) {
        OutputView.printResultMessage();
        for (int i = 0; i < numOfGame; i++) {
            racingCar.playOneRound();
            OutputView.printAllCarsStatus(racingCar);
        }
    }
}
