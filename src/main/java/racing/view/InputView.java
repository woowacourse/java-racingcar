package racing.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String getNextLine() {
        return SCANNER.nextLine();
    }

    public static int getNextInt() {
        return Integer.parseInt(SCANNER.nextLine());
    }
}
