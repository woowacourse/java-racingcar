package racingcar.view;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public String readCarNamesInput() {
        return scanner.nextLine();
    }

    public int readRoundNumberInput() {
        return Integer.parseInt(scanner.nextLine());
    }

    public void terminate() {
        scanner.close();
    }
}
