package cal;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public Expression inputNumbers() {
        System.out.println("문자열을 입력하세요,");
        String[] string = scanner.nextLine().split(" ");
        Expression expression;

        try {
            expression = new Expression(string);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputNumbers();
        }
        return expression;
    }
}
