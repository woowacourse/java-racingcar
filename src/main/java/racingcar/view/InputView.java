package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ROUND_NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String NOTHING_INPUT_ERROR_MASSAGE = "입력이 존재하지 않음";
    private static final String NOT_NUMBER_ERROR_MASSAGE = "라운드 입력이 숫자가 아님";
    private static final String NOT_POSITIVE_NUMBER_ERROR_MESSAGE = "라운드 입력이 양수가 아님";
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String input = scanner.nextLine();
        validateInput(input);
        return input;
    }

    public static String inputRounds() {
        System.out.println(ROUND_NUMBER_INPUT_MESSAGE);
        String input = scanner.nextLine();
        validateInput(input);
        validateRounds(input);
        return input;
    }

    public static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(NOTHING_INPUT_ERROR_MASSAGE);
        }
    }

    public static void validateRounds(String round) {
        validateDigit(round);
        validatePositiveNumber(round);
    }

    private static void validateDigit(String round) {
        if (round.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MASSAGE);
        }
    }

    private static void validatePositiveNumber(String round) {
        if (Integer.parseInt(round) > 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}
