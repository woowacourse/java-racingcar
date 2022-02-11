package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.Input;
import java.util.ArrayList;
import java.util.List;

public class InputController {
    private static final String SPLIT_DELIM = ",";

    public static List<Car> inputCarList() {
        return saveCarList();
    }

    public static int inputTryNum() {
        return saveTryNumber();
    }

    private static List<Car> saveCarList() {
        while (true) {
            String names = Input.inputCarNames();

            try {
                Validation.carNameValidation(names);
                return splitList(names);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Car> splitList(String names) {
        List<Car> carList = new ArrayList<>();
        String[] carNames = names.split(SPLIT_DELIM);

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
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
