package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String getCarNames() {
        OutputView.printInputCarNamesMessage();
        return SCANNER.nextLine();
    }

    public static int getTryNumber() {
        OutputView.printInputTryNumberMessage();
        try {
            int tryNumber = SCANNER.nextInt();
            return tryNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException("시도횟수는 숫자여야 합니다.");
        }
    }
}