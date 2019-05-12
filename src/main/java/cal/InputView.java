/*
 * @(#)InputView.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */

package cal;

import java.util.Scanner;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
public class InputView {
    /*계산기 입력에 관한 클래스*/
    private static final Scanner scanner = new Scanner(System.in);
    private static final String expressionPattern = "^(-?[0-9]+)(\\s(\\+|-|\\*|/)\\s(-?[0-9]+))+$";

    public static String inputExpression() {
        try {
            System.out.println("식을 입력하세요 : ");
            return checkExpression(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputExpression();
        }
    }

    static String checkExpression(String expression) {
        if (!expression.matches(expressionPattern)) {
            throw new IllegalArgumentException("잘못 된 식입니다.");
        }
        return expression;
    }
}
