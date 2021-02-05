package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getCarNames() {
        return SCANNER.nextLine();
    }

    public static int getAttemptNumber() {
        try {
            int attemptNumber = SCANNER.nextInt();
            return attemptNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException("시도횟수는 숫자여야 합니다.");
        }
    }

}