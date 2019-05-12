package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MaxFinder {

    public static <T> ArrayList<T> findAllMax(ArrayList<T> values, Comparator<T> comp) {
        T maxVal = Collections.max(values, comp);

        return new ArrayList<>(values.stream()
                .filter((T curVal) -> comp.compare(curVal, maxVal) == 0)
                .collect(Collectors.toList()));
    }
}
