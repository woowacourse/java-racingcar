package racingcar.view;

import java.util.Scanner;

public class InputView {

    public static String requestUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
