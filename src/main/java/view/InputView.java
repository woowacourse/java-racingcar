package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int readNumber() {
        return sc.nextInt();
    }

    public static String[] readNames() {
        return sc.nextLine().split(",");
    }
}
