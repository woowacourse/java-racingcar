package game.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        return UserInputCheck.checkCarNames(scanner.nextLine());
    }

    public static int inputTryCount() {
        try {
            System.out.println("시도할 회수는 몇 회인가요?");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return inputTryCount();
        }
    }
}