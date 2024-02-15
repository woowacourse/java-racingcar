package utils;

import java.util.ArrayList;
import java.util.List;

public class Convertor {

    public static List<String> convertStringToList(String input) {
        String[] names = input.split(",");
        return new ArrayList<>(List.of(names));
    }
}
