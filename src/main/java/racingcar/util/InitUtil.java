package racingcar.util;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.VerificationUtil.*;

public class InitUtil {

    private static final String SEPARATOR = ",";

    private InitUtil() {
    }

    public static int initTotalAttempt(String attempt) throws IllegalArgumentException {
        return validateAttempt(attempt);
    }
}
