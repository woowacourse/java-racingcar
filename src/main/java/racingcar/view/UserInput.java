package racingcar.view;

import java.util.Scanner;

public class UserInput implements Input {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public int gameCountInput() {
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String carNameInput() {
        return scanner.nextLine();
    }
}
