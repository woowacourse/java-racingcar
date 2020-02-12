package racingGame;

import java.util.Scanner;

public class InputView {
    private static final Scanner s = new Scanner(System.in);

    public static String inputName() {
        return s.nextLine();
    }

    public static String inputRepeat() {
        return s.nextLine();
    }
}
