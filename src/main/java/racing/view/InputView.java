package racing.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    private String readLine() {
        String input = scanner.nextLine();
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public int readInt(){
        return Integer.parseInt(readLine());
    }
}
