package view;

import racingCar.Car;
import utils.InputCheckUtil;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        InputCheckUtil.inputValidate(input);
        return input;
    }

    public static int getTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String stringNum = scanner.next();
        if (!stringNum.chars().allMatch(Character::isDigit) ||
                Integer.parseInt(stringNum) < 1) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요.");
        }
        return Integer.parseInt(stringNum);
    }

}
