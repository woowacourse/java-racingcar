package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static void terminate() {
        scanner.close();
    }

    public String readCarNamesInput(){
        return scanner.nextLine();
    }

    public int readRoundNumberInput(){
        return Integer.parseInt(scanner.nextLine());
    }
}
