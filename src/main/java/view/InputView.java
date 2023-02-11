package view;

import constant.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SPLIT_NAME_INDICATOR = ",";
    private static final int NEGATIVE_NUMBER_INDICATOR = 0;

    private Scanner scanner = new Scanner(System.in);

    public List<String> inputCarName() {
        return splitCarName(scanner.nextLine());
    }

    private List<String> splitCarName(String carsName) {
        return Arrays.asList(carsName.split(SPLIT_NAME_INDICATOR));
    }

    public int inputTryCount() {
        try {
            int tryCount = Integer.parseInt(scanner.nextLine());
            return validPositiveNumber(tryCount);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_NOT_NUMBER_MESSAGE.getExceptionMessage());
        }
    }

    private int validPositiveNumber(int number) {
        if (number <= NEGATIVE_NUMBER_INDICATOR) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_TRY_COUNT_MESSAGE.getExceptionMessage());
        }
        return number;
    }
}
