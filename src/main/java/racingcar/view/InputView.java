package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준 기준으로 구분).");
        return sc.nextLine();
    }

    public static int inputTotalLap() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = sc.nextLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("전체 바퀴 수는 숫자만 입력 가능합니다.");
        }
    }
}
