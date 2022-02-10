package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameController {
    private Cars cars;
    private int trialNum;

    public void run() {
        initGame();
        runGame();
    }

    private void initGame() {
        InputView.inputCarNames();
        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.nextLine();
        List<String> carNameList = splitCars(carNames);
        cars = initCars(carNameList);
        InputView.inputTrialNum();
        trialNum = scanner.nextInt();
    }

    public List<String> splitCars(String carNames) {
        List<String> carNameList = Arrays.asList(carNames.split(","));
        InputValidator.validateCarName(carNameList);

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
}
