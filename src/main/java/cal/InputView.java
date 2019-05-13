package cal;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static InputValues inputNumbers(){
        System.out.println("문자열을 입력하세요,");
        String[] string = scanner.nextLine().split(" ");
        InputValues inputValues;

        try {
             inputValues = new InputValues(string);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputNumbers();
        }
        return inputValues;
    }
}
