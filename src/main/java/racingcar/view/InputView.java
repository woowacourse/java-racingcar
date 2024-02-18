package racingcar.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final Pattern ONLY_DIGIT_PATTERN = Pattern.compile("-?[0-9]+");
    private static Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = scanner.nextLine();

        validateInput(input);
        return input;
    }

    public static String inputRound() {
        System.out.println(INPUT_ROUND_MESSAGE);
        String input = scanner.nextLine();

        validateRound(input);
        return input;
    }

    private static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력은 공백일 수 없습니다.");
        }
    }

    private static void validateRound(String input) {
        validateInput(input);

        if (isNotDigit(input)) {
            throw new IllegalArgumentException("시도할 회수에 대한 입력은 숫자만 가능합니다.");
        }
    }

    private static boolean isNotDigit(final String input) {
        return !ONLY_DIGIT_PATTERN.matcher(input).
                matches();
    }
}
