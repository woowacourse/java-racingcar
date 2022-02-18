package racingcar.view.InputView;

import racingcar.utils.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    private static final String CARNAME_INPUT_ALERT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRIAL_COUNT_INPUT_ALERT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String NAME_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputCarNames() {
        System.out.println(CARNAME_INPUT_ALERT_MESSAGE);
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

    public String inputTrialCount() {
        System.out.println(TRIAL_COUNT_INPUT_ALERT_MESSAGE);
        String inputTrialCount = scanner.nextLine();

        validateBlankInput(inputTrialCount);

        return inputTrialCount;
    }
}
 