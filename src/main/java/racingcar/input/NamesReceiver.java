package racingcar.input;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.input.validator.NamesValidator;
import racingcar.view.View;

public class NamesReceiver {

    public static final String NAME_DELIMITER = ",";

    private Scanner scanner;
    private NamesValidator namesValidator;
    private View view;
    private String receivedNames;

    public NamesReceiver() {
        this.scanner = new Scanner(System.in);
        this.namesValidator = new NamesValidator();
        this.view = new View();
        this.receivedNames = null;
    }

    public List<String> receive() {
        while (!checkRules()) {
        }
        return parseNames(receivedNames);
    }

    private boolean checkRules() {
        try {
            view.printInputNamesMessage();
            receivedNames = namesValidator.validate(scanner.nextLine());
            return true;
        } catch (IllegalArgumentException exception) {
            view.printExceptionMessage(exception);
            return false;
        }
    }

    private List<String> parseNames(String names) {
        return Arrays.stream(names.split(NAME_DELIMITER))
                .collect(toList());
    }
}
