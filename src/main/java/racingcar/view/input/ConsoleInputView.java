package racingcar.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    private static final String NOT_POSITIVE_DIGIT = "시도 횟수는 양의 정수만 가능합니다.";
    private static final String BLANK_INPUT_EXCEPTION_MESSAGE = "입력이 비어있습니다.";
    private static final String CAR_NAME_INPUT_ALERT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRIAL_COUNT_INPUT_ALERT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final String NAME_DELIMITER = ",";
    private static final Pattern TRIAL_COUNT_PATTERN = Pattern.compile("^[0-9]*$");

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public List<String> inputCarNames() {
        System.out.println(CAR_NAME_INPUT_ALERT_MESSAGE);
        final String inputCarNames = scanner.nextLine();
        validateBlankInput(inputCarNames);
        return Arrays.stream(inputCarNames.split(NAME_DELIMITER))
                .collect(Collectors.toList());
    }

    private void validateBlankInput(final String inputString) {
        if (inputString.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public int inputTrialCount() {
        System.out.println(TRIAL_COUNT_INPUT_ALERT_MESSAGE);
        String inputTrialCount = scanner.nextLine();
        validateBlankInput(inputTrialCount);
        validatePositiveDigit(inputTrialCount);
        return Integer.parseInt(inputTrialCount);
    }

    private void validatePositiveDigit(final String inputString) {
        if (!TRIAL_COUNT_PATTERN.matcher(inputString).matches() || inputString.equals("0")) {
            throw new IllegalArgumentException(NOT_POSITIVE_DIGIT);
        }
    }
}
 