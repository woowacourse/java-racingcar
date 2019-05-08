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
            System.out.println("0이 분모에 있습니다.");
            Calculator.doCalculate();
        }
        return result / number;
    }

    public static int extractNumbersException(String stringNumber) {
        try{
            return Integer.parseInt(stringNumber);
        }catch (Exception e){
            System.out.println("잘못된 입력값입니다! 숫자가 아닙니다!");
            Calculator.doCalculate();
        }
        return -1;
    }

    public static int applyCalculationException(){
        System.out.println("잘못된 입력값입니다. 기호가 아닙니다!");
        Calculator.doCalculate();
        return -1;
    }

}
