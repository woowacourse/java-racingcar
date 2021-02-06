package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String IS_NOT_NUMBER_ERROR_MSG = "[ERROR] 숫자를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String nextLine() {
        return scanner.nextLine();
    }

    public static String getCarsName() {
        OutputView.printInputCarsNameMessage();
        return nextLine();
    }

    public static int getNumberOfRounds(){
        OutputView.printInputNumberOfRoundsMessage();
        try {
            return Integer.parseInt(InputView.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER_ERROR_MSG);
        }
    }
}
