package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Name;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class GameController {
    private static final String COMMA = ",";
    private static final String BLANK = "";
    private static final String SPACE = " ";

    private Cars cars;
    private int trialNum;

    public void run() {
        initGame();
        runGame();
        endGame();
    }

    private void initGame() {
        inputCarNames();
        inputTrialNum();
    }

    private void inputCarNames() {
        InputView.inputCarNames();
        String carNamesInput = InputView.getInput();
        List<Name> carNames = splitCars(carNamesInput);
        cars = initCars(carNames);
    }

    private void inputTrialNum() {
        InputView.inputTrialNum();
        String trialNumInput = InputView.getInput();
        trialNum = convertToInteger(trialNumInput);
    }

    public List<Name> splitCars(String carNamesInput) {
        InputValidator.validateBlank(carNamesInput);
        String inputWithoutSpace = carNamesInput.replaceAll(SPACE, BLANK);
        return Arrays.stream(inputWithoutSpace.split(COMMA))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public Cars initCars(List<Name> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    private int convertToInteger(String number) {
        InputValidator.validateTrialInput(number);
        return Integer.parseInt(number);
    }

    private void runGame() {
        OutputView.printTrialResult();
        for (int i = 0; i < trialNum; i++) {
            cars.race();
            OutputView.printCarPosition(cars);
        }
    }

    private void endGame() {
        OutputView.printWinnerName(findWinner(cars));
    }

    public String findWinner(Cars cars) {
        int maxPosition = cars.findMaxPosition();
        return cars.findWinnerName(maxPosition);
    }
}
