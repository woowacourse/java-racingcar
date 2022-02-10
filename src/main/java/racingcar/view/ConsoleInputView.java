package racingcar.view;

import racingcar.utils.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    private static final String NAME_DELIMITER = ",";
    private static final String ZERO_AND_POSITIVE_DIGIT = "^[0-9]*$";
    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputCarNames() {
        String inputCarNames = scanner.nextLine();
        validateBlankInput(inputCarNames);
        return Arrays.stream(inputCarNames.split(NAME_DELIMITER))
                .collect(Collectors.toList());
    }

    private void validateBlankInput(String inputString) {
        if (inputString.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public int inputTrialCount() {
        String inputTrialCount = scanner.nextLine();
        validateBlankInput(inputTrialCount);
        validatePositiveDigit(inputTrialCount);
        return Integer.parseInt(inputTrialCount);
    }

    private void validatePositiveDigit(String inputString) {
        if (!inputString.matches(ZERO_AND_POSITIVE_DIGIT) || inputString.equals("0")) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_POSITIVE_DIGIT);
        }
    }
}