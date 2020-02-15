package racingCar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputUserNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int InputNumberOfRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int result = scanner.nextInt();
            checkMinus(result);
            return result;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("다시 입력해 주세요");
            return InputNumberOfRound();
        }
    }

    private static void checkMinus(int num) throws InputMismatchException {
        if (num <= 0) {
            throw new InputMismatchException();
        }
    }

}
