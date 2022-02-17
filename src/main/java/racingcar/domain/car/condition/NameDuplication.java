package racingcar.domain.car.condition;

import java.util.Collections;
import java.util.List;

public class NameDuplication {

    private static final int ALLOWED_MAXIMUM_COUNT = 1;

    private NameDuplication() {
    }

    public static boolean isExcessiveDuplicated(final List<String> names, String name) {
        return Collections.frequency(names, name) > ALLOWED_MAXIMUM_COUNT;
    }

}
