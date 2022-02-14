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
        try (Scanner scanner = new Scanner(System.in)) {
            InputView.inputCarNames();
            String carNames = scanner.nextLine();
            List<String> splitCarNames = splitCars(carNames);
            cars = initCars(splitCarNames);
            InputView.inputTrialNum();
            trialNum = convertToInteger(scanner.nextLine());
        }
    }

    public List<String> splitCars(String carNames) {
        InputValidator.validateNameInput(carNames);
        List<String> splitCarNames = Arrays.asList(splitNameWithoutSpace(carNames));
        InputValidator.validateEmptyCarName(splitCarNames);
        InputValidator.validateCarNameLength(splitCarNames);
        InputValidator.validateDuplicateName(splitCarNames);

        return splitCarNames;
    }

    private String[] splitNameWithoutSpace(String carNames) {
        return carNames.replaceAll(SPACE, BLANK).split(COMMA);
    }

    public Cars initCars(List<String> carNames) {
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
        OutputView.printWinnerName(cars.findWinner());
    }
}
