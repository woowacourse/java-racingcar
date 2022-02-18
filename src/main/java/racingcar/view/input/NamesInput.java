package racingcar.view.input;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.validator.NamesSettingValidator;
import racingcar.view.View;

public class NamesInput {

    public static final String NAME_DELIMITER = ",";

    private Scanner scanner;
    private NamesSettingValidator namesSettingValidator;
    private View view;

    public NamesInput() {
        this.scanner = new Scanner(System.in);
        this.namesSettingValidator = new NamesSettingValidator();
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
            namesSettingValidator.validate(names);
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
