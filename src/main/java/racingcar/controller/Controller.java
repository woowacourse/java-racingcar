package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import java.util.ArrayList;
import java.util.List;
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
        Cars cars = generateCars(inputView.readCarNames());
        int round = inputView.readRacingRound();
        playGame(cars, round);
    }

    private Cars generateCars(List<String> carNames) {
        List<Car> carInstances = new ArrayList<>();
        for (String name : carNames) {
            carInstances.add(new Car(name, numberGenerator));
        }
        return new Cars(carInstances);
    }

    private void playGame(Cars cars, int round) {
        outputView.printResultMessage();
        for (int i = 0; i < round; i++) {
            outputView.printRoundResult(cars.moveEachCar());
        }
        outputView.printFinalResult(cars.findAllWinner());
    }

}
