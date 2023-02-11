package view.input;

import view.output.OutputView;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static List<String> readCarName() {
        OutputView.printCarNamesInputMessage();

        final String delimiter = ",";
        String carNames = scanner.nextLine();
        List<String> splitCarNames = List.of(carNames.split(delimiter));

        InputValidator.validateCarName(splitCarNames);
        return splitCarNames;
    }

    public static int readGameTry() {
        OutputView.printTryCountInputMessage();

        String gameTry = scanner.nextLine();

        InputValidator.validateGameTry(gameTry);
        return Integer.parseInt(gameTry);
    }
}
