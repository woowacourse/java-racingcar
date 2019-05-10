package game.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        return sc.nextLine();
    }

    public static int inputGameCount() {
        try {
            System.out.println("시도할 회수는 몇 회인가요?");
            return sc.nextInt();
        } catch (InputMismatchException e) {
            return inputGameCount();
        }
    }
}