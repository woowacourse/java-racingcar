package racingcar;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String carNames() {
        return scanner.nextLine();
    }

    public static int tryCount() {
        return Integer.parseInt(scanner.nextLine());
    }
}
