package racingcar.domain.car.condition;

import java.util.Collections;
import java.util.List;

public enum NameDuplication {

    ALLOWED_MAXIMUM_COUNT(1);

    private final int count;

    NameDuplication(final int count) {
        this.count = count;
    }

    public static boolean isExcessiveDuplicated(final List<String> names, final String name) {
        return Collections.frequency(names, name) > ALLOWED_MAXIMUM_COUNT.count;
    }

}
