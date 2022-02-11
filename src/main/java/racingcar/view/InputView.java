package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputNamesUi() {
        OutputView.printInputNamesUi();
        return scanner.nextLine();
    }

    public static String InputTryCountUi() {
        OutputView.printInputTryCountUi();
        return scanner.nextLine();
    }
}
