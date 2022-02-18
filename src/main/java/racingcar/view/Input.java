package racingcar.view;

import racingcar.util.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {
    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_MESSAGE = "시도할 회수는 몇회인가요?";

    private final static Scanner sc = new Scanner(System.in);

    public static List<String> getCarNamesSeperatedByDelimiter(String delimiter) {
        String carNamesInput = inputCarNames();
        Validation.carNameValidation(carNamesInput);
        return Arrays.stream(carNamesInput.split(delimiter))
                .collect(Collectors.toList());
    }

    public static int getTryNum() {
        String tryValue = inputTry();
        Validation.tryNumValidation(tryValue);
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
