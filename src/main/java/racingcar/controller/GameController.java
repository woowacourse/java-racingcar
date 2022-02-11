package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void start() {
        String carNames = InputView.inputCarNames();
        String[] names = Parser.split(carNames);
        Cars cars = new Cars(names);

        String rounds = InputView.inputRounds();
        Parser.isValidRounds(rounds);
        runRounds(rounds, cars);

        OutputView.printChampionList(cars);
    }

    private void runRounds(String rounds, Cars cars) {
        for (int i = 0; i < Integer.parseInt(rounds); i++) {
            cars.moveCars();
            OutputView.printRaceResult(cars);
        }
    }
}
