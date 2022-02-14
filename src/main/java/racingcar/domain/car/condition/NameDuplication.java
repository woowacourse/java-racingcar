package racingcar.domain.car.condition;

import java.util.Collections;
import java.util.List;

public enum NameDuplication {

    MAXIMUM(1);

    private final int number;

    NameDuplication(int number) {
        this.number = number;
    }

    public static boolean isExcessiveDuplicated(List<String> names, String name) {
        return (Collections.frequency(names, name) > MAXIMUM.number);
    }

}
