package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String NOTHING_INPUT_ERROR_MASSAGE = "입력이 존재하지 않음";
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        validateInput(input);
        return input;
    }

    public static String inputRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        validateRounds(input);
        return input;
    }

    public static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(NOTHING_INPUT_ERROR_MASSAGE);
        }
    }

    public static void validateRounds(String round) {
        if (round == null || !isDigit(round) || !isPositiveNumber(round)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDigit(String round) {
        if (round.chars().allMatch(Character::isDigit)) {
            return true;
        }
        return false;
    }

    private static boolean isPositiveNumber(String round) {
        if (Integer.parseInt(round) > 0) {
            return true;
        }
        return false;
    }
}
