package racingcargame.view;

import java.util.Scanner;

import racingcargame.utils.NameInputValidator;
import racingcargame.utils.RaceCountInputValidator;

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
