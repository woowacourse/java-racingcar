package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
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
        InputView.inputCarNames();
        String inputCarNames = InputView.getInput();
        List<String> carNames = splitCars(inputCarNames);
        cars = initCars(carNames);

        InputView.inputTrialNum();
        String inputTrialNum = InputView.getInput();
        trialNum = convertToInteger(inputTrialNum);
    }

    private int convertToInteger(String number) {
        InputValidator.validateTrialInput(number);
        return Integer.parseInt(number);
    }

    public List<String> splitCars(String carNamesInput) {
        InputValidator.validateNameInput(carNamesInput);
        String carNamesWithoutSpace = carNamesInput.replaceAll(SPACE, BLANK);
        List<String> carNames = Arrays.asList(carNamesWithoutSpace.split(COMMA));
        InputValidator.validateCarName(carNames);
        InputValidator.validateDuplicateName(carNames);

        return carNames;
    }

    public Cars initCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
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
