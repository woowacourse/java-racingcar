package view;

import constant.ExceptionMessage;

import java.util.Scanner;

public class InputView {
    private final int MIN_TRY_COUNT_INPUT = 1;

    private final Scanner scanner = new Scanner(System.in);

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
        if (number < MIN_TRY_COUNT_INPUT) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_TRY_COUNT_MESSAGE.getExceptionMessage());
        }
        return number;
    }
}
