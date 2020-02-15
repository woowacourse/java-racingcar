package racingCar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String RACING_CAR_ASK_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_NUM_ASK_TEXT = "시도할 횟수는 몇 회인가요?";
    private static final String REINPUT_REQUEST_TEXT = "다시 입력해 주세요";
    private static final int ZERO = 0;

    private InputView() {
    }

    public static String inputUserNames() {
        System.out.println(RACING_CAR_ASK_TEXT);
        return scanner.nextLine();
    }

    public static int InputNumberOfRound() {
        System.out.println(TRY_NUM_ASK_TEXT);
        try {
            int result = scanner.nextInt();
            checkMinus(result);
            return result;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println(REINPUT_REQUEST_TEXT);
            return InputNumberOfRound();
        }
    }

    private static void checkMinus(int num) throws InputMismatchException {
        if (num <= ZERO) {
            throw new InputMismatchException();
        }
    }

}
