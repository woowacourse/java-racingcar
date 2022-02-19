package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_RACING_TIMES_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    public String requestCarNames() {
        System.out.println(INPUT_NAME_MESSAGE);
        return inputFromUser();
    }

    public int requestPlayTimes() {
        System.out.println(INPUT_RACING_TIMES_MESSAGE);
        return Integer.parseInt(inputFromUser());
    }

    private String inputFromUser() {
        return SCANNER.nextLine();
    }
}
