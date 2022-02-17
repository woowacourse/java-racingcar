package racingcar.view;

import racingcar.util.Validation;

import java.util.Scanner;

public class Input {
    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_MESSAGE = "시도할 회수는 몇회인가요?";

    private final static Scanner sc = new Scanner(System.in);

    public static String[] getCarNamesSeperatedByDelimiter(String delimiter) {
        String carNamesInput = inputCarNames();
        try {
            Validation.carNameValidation(carNamesInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNamesSeperatedByDelimiter(delimiter);
        }
        return carNamesInput.split(delimiter);
    }

    public static int getTryNum() {
        String tryValue = inputTry();
        try {
            Validation.tryNumValidation(tryValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryNum();
        }
        return Integer.parseInt(tryValue);
    }

    private static String inputCarNames() {
        System.out.println(INPUT_CAR_MESSAGE);
        String inputName = sc.next();
        return inputName;
    }

    private static String inputTry() {
        System.out.println(INPUT_TRY_MESSAGE);
        String inputTry = sc.next();
        return inputTry;
    }
}
