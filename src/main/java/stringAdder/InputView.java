package stringAdder;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputValue(){
        System.out.println("문자열 수식을 입력해 주세요");
        return scanner.nextLine();
    }
}
