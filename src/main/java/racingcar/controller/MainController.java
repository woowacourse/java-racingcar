package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarRepository;
import racingcar.domain.game.Game;
import racingcar.utils.ErrorUtils;
import racingcar.view.MainPage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static racingcar.utils.ValidateUtils.validateNames;
import static racingcar.utils.ValidateUtils.validateTurnQuantity;

public class MainController {

    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
        userInputNames();
        userInputTurnQuantity();
    }

    public void userInputNames() {
        MainPage.printMainPage();
        String userInput = scanner.nextLine();
        try {
            splitNames(userInput);
        } catch (IllegalArgumentException e) {
            ErrorUtils.printError(e);
            userInputNames();
        }
    }

    public void userInputTurnQuantity() {
        MainPage.askTurnQuantity();
        String userInput = scanner.nextLine();
        try {
            initiateGameWithTurn(userInput);
        } catch (IllegalArgumentException e) {
            ErrorUtils.printError(e);
            userInputTurnQuantity();
        }
    }

    public void splitNames(String names) {
        List<Car> cars = Arrays.stream(names.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        validateNames(cars);
        CarRepository.addCars(cars);
    }

    public void initiateGameWithTurn(String userInput) {
        int turnQuantity = validateTurnQuantity(userInput);
        GameController gameController = new GameController();
        gameController.startGame(new Game(turnQuantity));
    }
}
