package com.woowacourse.stringcalculator;

import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {
        while (true) {
            System.out.println("식을 입력하세요");
            try {
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                StringCalculator calc = StringCalculatorUtil.parseCalculator(input);
                int result = calc.calculate();
                System.out.printf("결과는 %d입니다\n", result);
                break;
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("올바르지 않은 식입니다");
                continue;
            }
        }
    }
}
