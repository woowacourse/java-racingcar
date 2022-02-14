package racingcargame.view;

import racingcargame.utils.NameInputValidator;
import racingcargame.utils.RaceCountInputValidator;

import java.util.Scanner;

public class InputView {
    private static final InputView INPUT_CONTROLLER = new InputView();
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static InputView getInputController() {
        return INPUT_CONTROLLER;
    }

    public String inputCarName() {
        return NameInputValidator.validateCarNames(SCANNER.nextLine());
    }

    public String inputRaceCount() {
        return RaceCountInputValidator.validateRaceCount(SCANNER.nextLine());
    }
}
