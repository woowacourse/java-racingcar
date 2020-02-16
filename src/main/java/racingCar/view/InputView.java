package racingCar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String RACING_CAR_ASK_TEXT
            = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_NUM_ASK_TEXT = "시도할 횟수는 몇 회인가요?";
    private static final int ZERO = 0;

    private InputView() {
    }

    public static String inputUserNames() {
        System.out.println(RACING_CAR_ASK_TEXT);
        return scanner.nextLine();
    }

    public static int InputNumberOfRound() throws InputMismatchException {
        System.out.println(TRY_NUM_ASK_TEXT);
        int result = scanner.nextInt();
        checkMinus(result);
        return result;
    }

    private static void checkMinus(int num) throws InputMismatchException {
        if (num <= ZERO) {
            throw new InputMismatchException();
        }
    }

    public static void removeBuffer() {
        scanner.nextLine();
    }

}
