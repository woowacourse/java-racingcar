package racingCar.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private static int inputNumberToMove() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void inputSomething() {
        scanner.nextLine();
    }

    public static int setupGame() {
        OutputView.printStartingComment();
        InputView.inputSomething();
        OutputView.printAskingSentenceOfTry();
        int numberToMove = InputView.inputNumberToMove();
        System.out.println();
        return numberToMove;
    }
}
