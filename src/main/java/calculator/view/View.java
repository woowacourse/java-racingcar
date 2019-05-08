package calculator.view;

import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);

    public static String[] input() {
        String[] values;
        do {
            print("계산할 수식을 입력해 주세요 : ");
            values = scanner.nextLine().split(" ");
        } while (!Validator.isValid(values));
        return values;
    }

    public static void println(String aString){
        System.out.println(aString);
    }

    public static void print(String aString){
        System.out.println(aString);
    }
}
