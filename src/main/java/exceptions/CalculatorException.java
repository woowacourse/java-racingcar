package exceptions;

import calculator.Calculator;

import java.util.Scanner;

public class CalculatorException {

    public static String readAndReceiveInput() {
        System.out.println("숫자를 입력해 주세요!");
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }

    public static int divisionException(int result, int number){
        if (number == 0) {
            Calculator.doCalculate();
        }
        return result / number;
    }

}
