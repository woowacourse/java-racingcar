package racingcargame.controller;

import racingcargame.utils.NameInputValidator;

import java.util.Scanner;

public class InputController {
    private static final InputController inputController = new InputController();
    private static final Scanner scanner = new Scanner(System.in);

    private InputController() {
    }

    public static InputController getInputController() {
        return inputController;
    }

    public String inputCarName() {
        String carNames = scanner.nextLine();
        return NameInputValidator.validateCarNames(carNames);
    }
}
