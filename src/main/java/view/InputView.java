package view;

import constant.ExceptionMessage;

import java.util.Scanner;

public class InputView {
    private static final int CHECK_NEGATIVE_NUMBER = 0;
    private Scanner scanner = new Scanner(System.in);
    public String inputCarName() {
        return scanner.nextLine();
    }

    public int inputTryCount() {
        try {
            int tryCount = Integer.parseInt(scanner.nextLine());
            return checkPositiveNumber(tryCount);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_NOT_NUMBER_MESSAGE.getExceptionMessage());
        }
    }

    private int checkPositiveNumber(int number) {
        if (number <= CHECK_NEGATIVE_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_TRY_COUNT_MESSAGE.getExceptionMessage());
        }
        return number;
    }
}
