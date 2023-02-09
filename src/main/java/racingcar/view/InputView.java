package racingcar.view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String readCarNames() {
        String carNames = scanner.nextLine();
        return carNames;
    }

    public static int readTryCount() {
        try {
            int tryCount = Integer.parseInt(scanner.nextLine());
            return tryCount;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.");
        }
    }
}