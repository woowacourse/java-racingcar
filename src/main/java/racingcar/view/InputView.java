package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner input = new Scanner(System.in);
    private final String NAME_LIST_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String TRIAL_COUNT_PROMPT = "시도할 회수는 몇회인가요?";

    private String readLineWithMessage(String message) {
        System.out.println(message);
        String line = input.nextLine();
        System.out.println();
        return line;
    }

    public List<String> getCarNames() {
        String line = readLineWithMessage(NAME_LIST_PROMPT);
        String[] words = line.split(",");
        return Arrays.asList(words);
    }

    public Integer getTrialCount() {
        String input_count = readLineWithMessage(TRIAL_COUNT_PROMPT);
        Integer count = Integer.parseInt(input_count);
        return count;
    }
}
