package racingcargame.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String inputCarName() {
        return NameInputValidator.validateCarNamesInput(SCANNER.nextLine());
    }

    public static String inputRaceCount() {
        return RaceCountInputValidator.validateRaceCountInput(SCANNER.nextLine());
    }
}
