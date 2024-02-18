package racingcar.view;

import racingcar.view.validator.InputValidator;
import static racingcar.view.OutputView.*;
import static racingcar.message.UserMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    public List<String> getCarNames() {
        displayMessage(USER_CAR_NAME_INPUT_PROMPT);
        String initialInput = scanner.nextLine();
        InputValidator.validateIsBlank(initialInput);

        List<String> parseCarNames = parseCarName(initialInput);
        InputValidator.validateAvailableNames(parseCarNames);
        return parseCarNames;
    }

    private List<String> parseCarName (String initialInput) {
        return Arrays.stream(initialInput.split(","))
                .map(String::trim)
                .toList();
    }

    public int getTryNumber() {
        displayMessage(USER_TRY_NUMBER_INPUT_PROMPT);
        String tryNumber = scanner.nextLine();
        InputValidator.validateTryNumber(tryNumber);

        return Integer.parseInt(tryNumber);
    }
}
