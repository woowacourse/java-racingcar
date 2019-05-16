package racingcargame.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNames {
    public static List<String> makeCarNames(String carNames) {
        CarNamesValidator.checkConditions(carNames);
        List<String> names = new ArrayList<>(Arrays.asList(carNames.split(",")));
        return names;
    }
}
