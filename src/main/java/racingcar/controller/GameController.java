package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.util.CarNameValidator;
import racingcar.util.RoundValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private static final String DELIMITER = ",";

    public void start() {
        Cars cars = new Cars(split(InputView.inputCarNames()));
        int rounds = toInts(InputView.inputRounds());

        runRounds(rounds, cars);

        OutputView.printChampionList(cars.getChampions());
    }

    private String[] split(String input) {
        CarNameValidator.checkCarNames(input);

        String[] carNames = input.split(DELIMITER);
        CarNameValidator.checkQuantity(carNames);

        for (String carName : carNames) {
            CarNameValidator.checkCarName(carName);
        }

        return carNames;
    }

    private int toInts(String input) {
        int rounds = Integer.parseInt(input);
        RoundValidator.checkPositive(rounds);
        return rounds;
    }

    private void runRounds(int rounds, Cars cars) {
        OutputView.printResultMessage();
        for (int i = 0; i < rounds; i++) {
            cars.moveAll();
            OutputView.printRoundResult(cars.getCars());
        }
    }
}
