package utils;

import java.util.ArrayList;
import java.util.List;

public class CarNameConvertor {
    private CarNameConvertor() {
    }

    public static List<String> splitCarNames(String input) {
        String[] names = input.split(",");

        return new ArrayList<>(List.of(names));
    }
}
