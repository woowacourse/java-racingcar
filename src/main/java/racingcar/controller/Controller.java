package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public Controller(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        List<String> carNames = inputView.readCarNames();
        Cars cars = generateCars(carNames);

        String trialCount = inputView.readRacingRound();
        Round round = new Round(trialCount);

        RacingGame racingGame = new RacingGame(cars, round);
        racingGame.playGame();

        showGameResult(racingGame);
    }

    private Cars generateCars(List<String> carNames) {
        List<Car> racingCars = new ArrayList<>();
        for (String name : carNames) {
            racingCars.add(new Car(name, numberGenerator));
        }
        return new Cars(racingCars);
    }

    private void showGameResult(RacingGame racingGame) {
        outputView.printResultMessage();
        outputView.printResult(racingGame.getResult());
        outputView.printFinalResult(racingGame);
    }

}
