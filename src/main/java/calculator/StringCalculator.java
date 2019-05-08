package calculator;

import java.util.Scanner;

public class StringCalculator {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static String inputString() {
        return SCANNER.nextLine();
    }

    public String[] splitString(String str){
        return str.split(" ");
    }



    public static void main(String[] args) {
//        String result = inputString();
//        for (String i : result) {
//            System.out.println(i);
//        }
    }
}