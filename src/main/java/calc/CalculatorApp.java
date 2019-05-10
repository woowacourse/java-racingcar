package calc;

import java.util.Scanner;
public class CalculatorApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("수식을 입력하여 주십시오.");
        try {
            System.out.println("감사합니다.\n결과값은 "
                + new Calculator(input.nextLine()) + "입니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다.");
        }
    }
}