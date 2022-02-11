package racingcargame.controller;

import java.util.List;
import java.util.Scanner;

import racingcargame.utils.NameInputValidator;
import racingcargame.utils.RaceCountInputValidator;

public class InputController {
    private static final InputController inputController = new InputController();
    private static final Scanner scanner = new Scanner(System.in);
    public static final String COMMA = ",";

    private InputController() {
    }

    public static InputController getInputController() {
        return inputController;
    }

    public List<String> inputCarName() {
        String carNames = scanner.nextLine();
        return List.of(NameInputValidator.validateCarNames(carNames).split(COMMA));
    }

    public int inputRaceCount() {
        String raceCount = scanner.nextLine();
        return Integer.parseInt(RaceCountInputValidator.validateRaceCount(raceCount));
    }
}
