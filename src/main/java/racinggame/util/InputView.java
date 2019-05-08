package racinggame.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getTrial() {
        System.out.println("시도할 횟수는 몇회인가요?");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
            return getTrial();
        }
    }
}
