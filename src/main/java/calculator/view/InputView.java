package calculator.view;

import java.util.*;

public class InputView {
    public static String askAndReceiveExpression() {
        System.out.println("계산할 식을 입력해 주세요!");
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine();
        return userInput;
    }
}
