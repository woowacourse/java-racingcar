package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputFormUser(Messages messages) {
        System.out.println(messages.getMessage());
        String input = scanner.nextLine();

        return input;
    }
}
