package racingcar.util;

import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.VerificationUtil.*;

public class InitUtil {

    private static final String SEPARATOR = ",";

    private InitUtil() {
    }

    public static List<Car> initCar(String carNames) throws IllegalArgumentException {
        List<Car> carList = new ArrayList<>();
        String[] names = carNames.split(SEPARATOR);

        validateDuplication(names);

        for (String name : names) {
            carList.add(new Car(name));
        }

        return carList;
    }

    public static int initTotalAttempt(String attempt) throws IllegalArgumentException {
        return validateAttempt(attempt);
    }
}
