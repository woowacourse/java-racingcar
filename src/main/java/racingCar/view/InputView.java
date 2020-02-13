package racingCar.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputNumberToMove() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static void inputSomething() {
        scanner.nextLine();
    }
}
