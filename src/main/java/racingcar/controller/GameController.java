package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class GameController {
    public static final String COMMA = ",";
    public static final String BLANK = "";
    public static final String SPACE = " ";

    private Cars cars;
    private int trialNum;

    public void run() {
        initGame();
        runGame();
        endGame();
    }

    private void initGame() {
        InputView.inputCarNames();
        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.nextLine();
        List<String> carNameList = splitCars(carNames);
        cars = initCars(carNameList);
        InputView.inputTrialNum();
        trialNum = convertToInteger(scanner.nextLine());
        scanner.close();
    }

    private int convertToInteger(String number) {
        InputValidator.validateTrialInput(number);
        return Integer.parseInt(number);
    }

    public List<String> splitCars(String carNames) {
        InputValidator.validateNameInput(carNames);
        List<String> carNameList = Arrays.asList(carNames.replaceAll(SPACE, BLANK).split(COMMA));
        InputValidator.validateCarName(carNameList);
        InputValidator.validateDuplicateName(carNameList);

        return carNameList;
    }

    public Cars initCars(List<String> carNameList) {
        return new Cars(carNameList.stream()
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
