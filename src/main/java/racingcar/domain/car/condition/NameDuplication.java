package racingcar.domain.car.condition;

import java.util.Collections;
import java.util.List;

public enum NameDuplication {

    ALLOWED_MAXIMUM_COUNT(1);

    private final int count;

    NameDuplication(int count) {
        this.count = count;
    }

    public static boolean isExcessiveDuplicated(List<String> names, String name) {
        return (Collections.frequency(names, name) > ALLOWED_MAXIMUM_COUNT.count);
    }

}
