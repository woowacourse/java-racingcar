package racingCar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        String[] carNames = input.split(",");
        validateEmpty(carNames);
        return Arrays.stream(carNames)
                .collect(Collectors.toList());
    }

    public static Integer readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        validateEmpty(input);
        return validateIsDigit(input);
    }

    private static void validateEmpty(String[] carNames) throws IllegalArgumentException {
        if (isBlank(carNames)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 다시 입력해주세요.");
        }
    }

    private static boolean isBlank(String[] carNames) {
        return carNames.length == 0;
    }

    private static void validateEmpty(String tryCount) throws IllegalArgumentException {
        if (isBlank(tryCount)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수를 다시 입력해주세요.");
        }
    }

    private static boolean isBlank(String tryCount) {
        return tryCount.length() == 0;
    }

    private static Integer validateIsDigit(String input) throws IllegalArgumentException {
        return Integer.parseInt(input);
    }
}
