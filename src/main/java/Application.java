import calculator.Calculator;

import java.util.Scanner;

public class Application {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("식을 입력해주세요");
        int result = Calculator.splitAndSum(scanner.nextLine());
        System.out.println(result);
    }

}

