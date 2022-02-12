package racingcargame.controller;

import java.util.List;
import java.util.Scanner;

import racingcargame.utils.NameInputValidator;
import racingcargame.utils.RaceCountInputValidator;

public class CarGameInputController {
    private static final CarGameInputController inputController = new CarGameInputController();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_NAME_DELIMITER = ",";

    private CarGameInputController() {
    }

    public static CarGameInputController getInputController() {
        return inputController;
    }

    public List<String> inputCarName() {
        String carNames = scanner.nextLine();
        return List.of(NameInputValidator.validateCarNames(carNames).split(CAR_NAME_DELIMITER));
    }

    public int inputRaceCount() {
        String raceCount = scanner.nextLine();
        return Integer.parseInt(RaceCountInputValidator.validateRaceCount(raceCount));
    }
}
