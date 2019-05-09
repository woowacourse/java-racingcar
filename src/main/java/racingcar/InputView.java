package racingcar;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getUserCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String userCarNames = SCANNER.nextLine();
        // Validator
        return getUserCarNames();
    }

    public static int getNumberOfGame() {
        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfGame = Integer.parseInt(SCANNER.nextLine());
        // Validator
        return getNumberOfGame();
    }
}
