package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getCarNamesInput() {
        OutputView.showCarNameGuideMessage();
        return scanner.nextLine();
    }

    public static String getLap() {
        OutputView.showLapGuideMessage();
        return scanner.nextLine();
    }

    public static void closeScanner(){
        scanner.close();
    }
}
