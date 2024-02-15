package util;

import domain.Car;
import java.util.Arrays;
import java.util.List;

public class StringConvertor {
    private static final String COMMA = ",";

    private StringConvertor() {
    }

    public static List<Car> convertListSplitByComma(String value) {
        return Arrays.stream(value.split(COMMA))
                .map(Car::from).toList();
    }
}
