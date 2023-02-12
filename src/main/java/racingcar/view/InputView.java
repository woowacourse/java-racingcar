package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String NON_NUMBER_TRIAL_COUNT_INPUT_ERROR_MESSAGE = "숫자가 아닌 값은 시도 횟수로 입력할 수 없습니다";
    private static final String NAME_LIST_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRIAL_COUNT_PROMPT = "시도할 회수는 몇회인가요?";
    private final Scanner input = new Scanner(System.in);
    private final OutputView output = new OutputView();

    private String readLineWithMessage(final String message) {
        System.out.println(message);
        return input.nextLine();
    }

    public List<String> getCarNames() {
        final String line = readLineWithMessage(NAME_LIST_PROMPT);
        output.printBlankLine();
        final String[] words = line.split(",");
        return Arrays.asList(words);
    }

    public int getTrialCount() {
        try {
            final String inputCount = readLineWithMessage(TRIAL_COUNT_PROMPT);
            output.printBlankLine();
            return Integer.parseInt(inputCount);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMBER_TRIAL_COUNT_INPUT_ERROR_MESSAGE);
        }
    }
}
