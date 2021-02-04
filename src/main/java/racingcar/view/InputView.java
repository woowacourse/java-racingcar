package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getCarNamesInput () {
        OutputView.showCarNameGuideMessage();
        return scanner.nextLine();
    }



}
