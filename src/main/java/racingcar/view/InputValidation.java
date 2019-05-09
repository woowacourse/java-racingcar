package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.InputMismatchException;

public class InputValidation {
    public static List<String> filterTypos(String arg) {
        return new ArrayList<>(
                Arrays.stream(arg.split(","))
                .filter(x -> (!x.equals("")) && (!x.equals(" ")) && (!x.equals(",")))
                .map(x -> x.trim())
                .collect(Collectors.toList())
        );
    }

    public static boolean areValidNames(List<String> names) {
        return names.size() > 1
                && names.size() == new HashSet<>(names).size()
                && names.stream().map(x -> x.length() <= 5).reduce(true, (x, y) -> x && y);
    }

    public static boolean isValidNumber(String line) {
        try {
            return Integer.parseInt(line) > 0;
        } catch (Exception e) {
            return false;
        }

    }
}