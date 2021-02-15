package racingcar.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    private static final String NAME_SEPARATOR = ",";

    public static String[] inputToNames(Scanner scanner) {
        OutputView.printInfo("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();
        return splitNames(names);
    }

    public static int inputToInteger(Scanner scanner) {
        OutputView.printInfo("시도할 회수는 몇회인가요?");
        String next = scanner.next();
        isOnlyNumber(next);
        return Integer.parseInt(next);
    }

    public static String[] splitNames(String line) {
        return Arrays.stream(line.split(NAME_SEPARATOR))
            .map(String::trim)
            .toArray(String[]::new);
    }

    public static void isOnlyNumber(String round) {
        for (char c : round.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Round must be integer");
            }
        }
    }
}
