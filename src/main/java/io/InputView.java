package io;

import io.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    InputValidator validator;
    Scanner sc = new Scanner(System.in);

    private static final String CAR_NAMES_DELIMITER = ",";

    public InputView(InputValidator validator) {
        this.validator = validator;
    }


    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.nextLine();
        validator.validateCarNamesFormat(carNames);

        return Arrays.asList(carNames.split(CAR_NAMES_DELIMITER));
    }

    public int readTryAmount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String text = sc.nextLine();
        validator.validateIntFormat(text);

        return Integer.parseInt(text);
    }
}
