package racingCar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        String[] names = input.split(",");
        validateNames(names);
        return Arrays.asList(names);
    }

    private static void validateNames(String[] input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("자동차는 1개 이상 입력해주세요.");
        }
    }

    private static boolean isBlank(String[] carNames) {
        return carNames.length == 0;
    }

    public static int readTryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        String input = scanner.nextLine();
        validateTryCount(input);
        return Integer.parseInt(input);
    }

    private static void validateTryCount(String tryCount) {
        if (isBlank(tryCount)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수를 다시 입력해주세요.");
        }
    }

    private static boolean isBlank(String tryCount) {
        return tryCount.length() == 0;
    }
}
