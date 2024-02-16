package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import utils.InputValidator;

public class InputView {

    private static final Scanner in = new Scanner(System.in);
    private static final String CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_NUMBER_MSG = "시도할 횟수는 몇회인가요?";

    public List<String> inputCarNames() {
        System.out.println(CAR_NAME_MSG);
        String carNames = in.next();
        return Arrays.asList(carNames.split(","));
    }

    public int inputTryNumber() {
        System.out.println(TRY_NUMBER_MSG);
        String tryNumber = in.next();
        InputValidator.tryNumberValidator(tryNumber);
        return Integer.parseInt(tryNumber);
    }
}
