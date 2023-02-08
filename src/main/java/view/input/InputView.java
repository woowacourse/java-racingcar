package view.input;

import view.output.OutputView;

import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);
    public static String inputCarName() {
        OutputView.printInputCarName();
        return sc.next();
    }

    public static String inputCount() {
        OutputView.printCount();
        return sc.next();
    }
}
