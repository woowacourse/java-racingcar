package utils;

import java.util.Scanner;

public class InputChecker {
    private static final Scanner scanner = new Scanner(System.in);

    public static void inputValidate(String input) {
        if (input.charAt(0) == ',' || input.charAt(input.length()-1) == ',') {
            throw new IllegalArgumentException("시작이나 끝에 콤마(,)가 올 수 없습니다.");
        }
    }

    public static String getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        inputValidate(input);
        return input;
    }

    public static int getNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String stringNum = scanner.next();
        if(!stringNum.chars().allMatch(Character::isDigit) ||
                Integer.parseInt(stringNum) < 1){
            throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요.");
        }
        return Integer.parseInt(stringNum);
    }
}
