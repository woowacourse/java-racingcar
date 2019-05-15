package domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxFinder {

    public static <T> List<T> findAllMax(List<T> values, Comparator<T> comp) {
        T maxVal = Collections.max(values, comp);

        return values.stream()
                .filter((T curVal) -> comp.compare(curVal, maxVal) == 0)
                .collect(Collectors.toList());
    }
}
