package racingcar.controller;

import static racingcar.utils.ValidateUtils.validateTurnQuantity;
import static racingcar.utils.ValidateUtils.validateUniqueCarNames;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarRepository;
import racingcar.domain.game.Game;
import racingcar.utils.ErrorUtils;
import racingcar.view.MainPage;

public class MainController {

    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
        userInputNames();
        userInputTurnQuantity();
    }

    private void userInputNames() {
        try {
            MainPage.printMainPage();
            String userInput = scanner.nextLine();
            registerCars(userInput);
        } catch (IllegalArgumentException e) {
            ErrorUtils.printError(e);
            userInputNames();
        }
    }

    private void userInputTurnQuantity() {
        try {
            MainPage.askTurnQuantity();
            String userInput = scanner.nextLine();
            initiateGameWithTurn(userInput);
        } catch (IllegalArgumentException e) {
            ErrorUtils.printError(e);
            userInputTurnQuantity();
        }
    }

    private void registerCars(String names) {
        List<String> carNames = Arrays.asList(names.split(","));
        validateUniqueCarNames(carNames);

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        CarRepository.addCars(cars);
    }

    private void initiateGameWithTurn(String userInput) {
        int turnQuantity = validateTurnQuantity(userInput);
        GameController gameController = new GameController();
        gameController.startGame(new Game(turnQuantity));
    }
}
