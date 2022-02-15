package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String SPLIT_REGEX = ",";
    private static final int SPLIT_LIMIT = -1;
    private static final String INPUT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] getCarNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        String input = scanner.nextLine();
        return input.split(SPLIT_REGEX, SPLIT_LIMIT);
    }

    public String getCount() {
        System.out.println(INPUT_COUNT_MESSAGE);
        return scanner.nextLine();
    }
}
