package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.Input;
import java.util.ArrayList;
import java.util.List;

public class InputController {
    public static List<Car> inputCarList() {
        return saveCarList();
    }

    public static int inputTryNum() {
        return savaTryNumber();
    }

    private static List<Car> saveCarList() {
        while (true) {
            String names = Input.inputCarNames();

            try {
                Validation.carNameValidation(names);
                List<Car> carList = splitList(names);
                return carList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Car> splitList(String names) {
        List<Car> carList = new ArrayList<>();
        String[] carNames = names.split(",");

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    private static int savaTryNumber() {
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
