package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RacingGame;
import java.util.ArrayList;
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public Controller(InputView inputView, OutputView outputView, NumberGenerator numberGenerator){
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        List<String> carNames = inputView.readCarNames();
        Cars cars = generateCars(carNames);
        int round = inputView.readRacingRound();
        RacingGame racingGame = new RacingGame(cars);
        showGameResult(racingGame, round);
    }

    private Cars generateCars(List<String> carNames) {
        List<Car> carInstances = new ArrayList<>();
        for(String name : carNames) {
            carInstances.add(new Car(name, numberGenerator));
        }
        return new Cars(carInstances);
    }

    private void showGameResult(RacingGame racingGame, int round) {
        outputView.printResultMessage();
        for(int i = 0; i < round; i++) {
            racingGame.playRound();
            outputView.printRoundResult(racingGame.getCars());
        }
        outputView.printFinalResult(racingGame.getCars());
    }

}
