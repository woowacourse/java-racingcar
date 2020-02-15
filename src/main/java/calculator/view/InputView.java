package calculator.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static String inputExpression() {
        System.out.println("쉼표(,) 또는 콜론(:)으로 구분해 더할 숫자를 입력해주세요.");
        System.out.println("구분자를 따로 지정하시려면 //와 \\n 사이에 구분자를 넣어주세요.(ex //;\\n1;2;3)");
        return scanner.nextLine();
    }
}
