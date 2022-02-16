package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.Input;
import java.util.ArrayList;
import java.util.List;

public class InputController {
    private static final String SPLIT_DELIM = ",";

    public static List<Car> inputCars() {
        return saveCars();
    }

    public static int inputTryNum() {
        return saveTryNum();
    }

    private static List<Car> saveCars() {
        while (true) {
            String names = Input.inputCarNames();

            try {
                Validation.carNameValidation(names);
                List<Car> cars = splitList(names);
                return cars;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Car> splitList(String names) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = names.split(SPLIT_DELIM);

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private static int saveTryNum() {
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
