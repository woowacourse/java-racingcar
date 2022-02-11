package racingcar.util;

import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.VerificationUtil.*;
import static racingcar.view.InputView.getAttemptCount;
import static racingcar.view.InputView.getCarNames;

public class InitUtil {

    public static final String SEPARATOR = ",";

    private InitUtil() {
    }

    public static List<Car> initCar() throws IllegalArgumentException {
        List<Car> carList = new ArrayList<>();
        String[] names = getCarNames().split(SEPARATOR);

        validateDuplication(names);

        for (String name : names) {
            validateCarName(name);
            carList.add(new Car(name));
        }

        return carList;
    }

    public static int initTotalAttempt() throws IllegalArgumentException {
        String attempt = getAttemptCount();

        validateAttempt(attempt);

        return Integer.parseInt(attempt);
    }
}
