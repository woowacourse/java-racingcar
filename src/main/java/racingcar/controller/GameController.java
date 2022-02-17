package racingcar.controller;

import racingcar.model.*;
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
    private TrialNum trialNum;

    public void start() {
        InputView.inputCarNames();
        String carNames = InputView.getInput();
        InputView.inputTrialNum();
        String trialNum = InputView.getInput();

        RacingGame racingGame = new RacingGame(carNames, trialNum);
    }
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

    public void inputTrialNum() {
        InputView.inputTrialNum();
        String trialNumInput = InputView.getInput();
        trialNum = new TrialNum(trialNumInput);
    }

    private void runGame() {
        OutputView.printTrialResult();
        for (int i = 0; i < trialNum.getValue(); i++) {
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
