package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import utils.ErrorMessage;

public class InputView {

    private static final Scanner in = new Scanner(System.in);
    private static final String CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_NUMBER_MSG = "시도할 횟수는 몇회인가요?";

    public List<String> inputCarNames() {
        System.out.println(CAR_NAME_MSG);
        String carNames = in.nextLine();
        return Arrays.asList(carNames.split(","));
    }

    public int inputTryNumber() {
        System.out.println(TRY_NUMBER_MSG);
        String tryNumber = in.nextLine();
        validatePositiveNumber(tryNumber);
        return Integer.parseInt(tryNumber);
    }


    private void validatePositiveNumber(String number) {
        int validateNumber = validateNumber(number);
        validatePositive(validateNumber);
    }

    private int validateNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER);
        }
    }
}
