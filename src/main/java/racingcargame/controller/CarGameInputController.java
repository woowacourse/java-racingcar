package racingcargame.controller;

import java.util.List;
import java.util.Scanner;

import racingcargame.utils.NameInputValidator;
import racingcargame.utils.RaceCountInputValidator;

public class CarGameInputController {
    private static final CarGameInputController INPUT_CONTROLLER = new CarGameInputController();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_NAME_DELIMITER = ",";

    private CarGameInputController() {
    }

    public static CarGameInputController getInputController() {
        return INPUT_CONTROLLER;
    }

    public List<String> inputCarName() {
        String carNames = SCANNER.nextLine();
        return List.of(NameInputValidator.validateCarNames(carNames).split(CAR_NAME_DELIMITER));
    }

    public int inputRaceCount() {
        String raceCount = SCANNER.nextLine();
        return Integer.parseInt(RaceCountInputValidator.validateRaceCount(raceCount));
    }
}
