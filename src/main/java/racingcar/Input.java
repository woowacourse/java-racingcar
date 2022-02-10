package racingcar;

import java.util.Scanner;

public class Input {
    private Scanner scanner;
    // Validator
    public Input() {
        scanner = new Scanner(System.in);
    }

    public String getNames() {
        return scanner.nextLine();
    }

    public String getCoin() {
        return scanner.nextLine();
    }

}
