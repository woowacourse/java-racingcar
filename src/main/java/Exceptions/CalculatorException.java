package Exceptions;

import Calculator.Calculator;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CalculatorException {
    public static String readInputException(){
        try {
            String userInput = readAndReceiveInput();
            if (isNotAllNumber(userInput)) {
                throw new IllegalAccessException();
            }
            return userInput;
        }catch (Exception e){
            return readInputException();
        }
    }

    public static String readAndReceiveInput() {
        System.out.println("숫자를 입력해 주세요!");
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }

    public static boolean isNotAllNumber(String userInput){
        List<String> numbers = new ArrayList<>(Arrays.asList(userInput.split(" ")));
        boolean notAllNumber = false;
        while (!notAllNumber && !numbers.isEmpty()) {
            notAllNumber = checkNotAllNumber(numbers.get(0));
            numbers.remove(0);
            numbers.remove(0);
        }
        return notAllNumber;
    }

    public static boolean checkNotAllNumber(String number) {
        if (number.matches("[0-9]+")){
            return false;
        }
        System.out.println("잘못된 입력값입니다!");
        return true;
    }

}
