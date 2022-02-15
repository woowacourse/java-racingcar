package racingcar.service;

import racingcar.util.Validation;
import racingcar.view.Input;

public class InputService {
    private static final String SPLIT_DELIM = ",";

    public static int inputTryNum() {
        return saveTryNumber();
    }

    public static String[] getCarNames() {
        String carNamesInput = Input.inputCarNames();
        try {
            Validation.carNameValidation(carNamesInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getCarNames();
        }
        return carNamesInput.split(SPLIT_DELIM);
    }

    private static int saveTryNumber() {
        while (true) {
            String tryValue = Input.inputTry();

            try {
                Validation.tryNumValidation(tryValue);
                return Integer.parseInt(tryValue);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
