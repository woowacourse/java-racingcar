package view;

import constant.ExceptionMessage;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String inputCarNames() {
        return scanner.nextLine();
    }

    public int inputTryCount() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    ExceptionMessage.TRY_COUNT_NOT_NUMBER_MESSAGE.getExceptionMessage());
        }
    }
}
