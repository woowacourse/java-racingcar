package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getInputCarsName() {
        OutputView.printAskCarNames();
        return scanner.nextLine().trim();
    }

    public static Integer getInputTurns() {
        OutputView.printAskTurns();
        int turns = scanner.nextInt();
        if (turns <= 0) {
            throw new RuntimeException();
        }
        return turns;
    }
}
