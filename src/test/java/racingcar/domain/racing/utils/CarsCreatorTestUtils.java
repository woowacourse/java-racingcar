package racingcar.domain.racing.utils;

import java.util.ArrayList;
import java.util.List;

public class CarsCreatorTestUtils {
    public static List<String> createCarNamesSizeOf(int carSize) {
        List<String> carNames = new ArrayList<>();
        for (int i = 0; i < carSize; i++) {
            carNames.add(String.valueOf(i));
        }
        return carNames;
    }
}
