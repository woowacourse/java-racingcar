package racingcar.view;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.domain.validator.NamesValidator;

public class NamesInput {

    public static final String NAME_DELIMITER = ",";

    private Scanner scanner;
    private NamesValidator namesValidator;
    private View view;

    public NamesInput() {
        this.scanner = new Scanner(System.in);
        this.namesValidator = new NamesValidator();
        this.view = View.getInstance();
    }

    public List<String> receive() {
        boolean retrySwitch = true;
        String names = null;
        while (retrySwitch) {
            view.printInputNamesMessage();
            names = scanner.nextLine();
            retrySwitch = !checkRules(names);
        }
        return parseNames(names);
    }

    private boolean checkRules(String names) {
        try {
            namesValidator.validate(names);
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
