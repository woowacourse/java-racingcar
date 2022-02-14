package racingcar.view;

import racingcar.utils.Validator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return getCarNames(scanner.nextLine());
    }

    private static String getCarNames(final String input) {
        try {
            Validator.checkBlankOrNull(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNames();
        }
    }

    public static int getCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        final String input = scanner.nextLine();
        return parseInt(input);
    }

    private static int parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요!");
            return getCount();
        }
    }
}
