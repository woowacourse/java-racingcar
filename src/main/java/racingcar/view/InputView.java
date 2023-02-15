package racingcar.view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String readCarNames() {
        return scanner.nextLine();
    }

    public static int readTryCount() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.");
        }
    }
}
