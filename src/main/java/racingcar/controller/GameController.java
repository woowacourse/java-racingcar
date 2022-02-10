package racingcar.controller;

import racingcar.model.Car;
import racingcar.util.InputValidator;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameController {
    public void run() {
        gameInit();
    }

    private void gameInit() {
        InputView.inputCarNames();
        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.nextLine();
        List<String> carNameList = splitCars(carNames);
        List<Car> carList = initCars(carNameList);
    }

    public List<String> splitCars(String carNames) {
        List<String> carNameList = Arrays.asList(carNames.split(","));
        InputValidator.validateCarName(carNameList);

        return carNameList;
    }

    public List<Car> initCars(List<String> carNameList) {
        return carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
