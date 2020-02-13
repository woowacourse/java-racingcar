package racingCar.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputNumberToMove() {
        return Integer.parseInt(scanner.nextLine());
    }

    public void inputSomething() {
        scanner.nextLine();
    }
}
