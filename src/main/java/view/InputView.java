package view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public String inputCarName() {
        return scanner.nextLine();
    }
}
