package calculator.view;

import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputFormula() {
        String[] values;
        do {
            output("계산할 수식을 입력해 주세요 : ");
            values = scanner.nextLine().split(" ");
        } while (!InputValidator.isValid(values));
        return values;
    }

    public static void outputLine(String aString){
        System.out.println(aString);
    }

    public static void output(String aString){
        System.out.print(aString);
    }
}
