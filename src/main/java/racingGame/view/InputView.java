package racingGame.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner s = new Scanner(System.in);

    public static String inputName() {
        OutputView.printNameFormat();
        return s.nextLine();
    }

    public static String inputRepeat() {
        OutputView.printRepeatFormat();
        return s.nextLine();
    }
}
