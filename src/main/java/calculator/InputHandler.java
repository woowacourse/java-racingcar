package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class InputHandler {

    static Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        System.out.println("식을 입력해주세요.");
        String input = scanner.nextLine();
        return input;
    }


}
