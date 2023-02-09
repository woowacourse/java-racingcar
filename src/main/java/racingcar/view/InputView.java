package racingcar.view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String readCarNames() {
        String carNames = scanner.nextLine();
        return carNames;
    }

    public static int readTryCount() {
        int tryCount = scanner.nextInt();
        return tryCount;
    }
}
