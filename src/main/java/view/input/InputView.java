package view.input;

import view.output.OutputView;

import java.util.Scanner;

public class InputView {

    public static String inputCarName() {
        OutputView.printInputCarName();
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}
