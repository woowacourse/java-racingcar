package racingcar.view;

import racingcar.domain.TrialCount;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner input = new Scanner(System.in);
    private final String NAME_LIST_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String TRIAL_COUNT_PROMPT = "시도할 회수는 몇회인가요?";

    private String readLineWithMessage(String message) {
        System.out.println(message);
        return input.nextLine();
    }

    public List<String> getCarNames() {
        String line = readLineWithMessage(NAME_LIST_PROMPT);
        String[] words = line.split(",");
        return Arrays.asList(words);
    }

    public TrialCount getTrialCount() {
        String input_count = readLineWithMessage(TRIAL_COUNT_PROMPT);
        Integer number = Integer.parseInt(input_count);
        return new TrialCount(number);
    }
}
