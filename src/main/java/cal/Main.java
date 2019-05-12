/*
 * @(#)Main.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */

package cal;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
public class Main {
    /*계산기 Main클래스*/
    static final Calculator cal = new Calculator();

    public static void main(String[] args) {
        try {
            String input = InputView.inputExpression();
            int result = cal.execute(input);
            OutputView.printResult(result);
        } catch (ArithmeticException e) {
            System.out.println("계산이 불가능합니다. 다시 입력해주세요!");
            main(null);
        }
    }
}
