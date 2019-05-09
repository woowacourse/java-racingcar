package stringcalculator;

import java.util.Scanner;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    public String inputText() {
        return sc.nextLine();
    }
}
