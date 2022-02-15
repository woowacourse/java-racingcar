package racingcar.service;

import racingcar.util.Validation;
import racingcar.view.Input;

public class InputService {
    private static final String SPLIT_DELIM = ",";

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

    public static int getTryNum() {
        String tryValue = Input.inputTry();
        try {
            Validation.tryNumValidation(tryValue);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                getTryNum();
            }
        return Integer.parseInt(tryValue);
    }
}
