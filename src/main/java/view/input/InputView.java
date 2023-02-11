package view.input;

import view.output.OutputView;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final InputValidator inputValidator = new InputValidator();

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readCarName() {
        OutputView.printCarNamesInputMessage();

        final String delimiter = ",";
        String carNames = scanner.nextLine();
        List<String> splitCarNames = List.of(carNames.split(delimiter));

        inputValidator.validateCarName(splitCarNames);
        return splitCarNames;
    }

    public int readGameTry() {
        OutputView.printTryCountInputMessage();

        String gameTry = scanner.nextLine();

        inputValidator.validateGameTry(gameTry);
        return Integer.parseInt(gameTry);
    }
}
