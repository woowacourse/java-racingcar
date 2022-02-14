package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRIAL_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String inputFromUser() {
        return scanner.nextLine();
    }

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return inputFromUser();
    }

    public static String inputTrials() {
        System.out.println(INPUT_TRIAL_MESSAGE);
        return inputFromUser();
    }
}
