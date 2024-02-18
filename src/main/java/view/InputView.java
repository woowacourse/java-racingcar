package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SCANNER.nextLine();
    }

    public static String getRacingRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return SCANNER.nextLine();
    }

    public static int parseRoundCounts(String roundCounts) {
        validateCounts(roundCounts);
        return Integer.parseInt(roundCounts);
    }

    private static void validateCounts(String counts) {
        try {
            Integer.parseInt(counts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }
}
