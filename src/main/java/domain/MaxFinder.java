package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MaxFinder {
//    public static <T> ArrayList<T> findAllMax(ArrayList<T> values, Comparator<T> comp) {
//        ArrayList<T> maxValues = new ArrayList<>();
//        T maxVal = values.get(0);
//        for(T value : values) {
//            if(comp.compare(value, maxVal) == 0) {
//                maxValues.add()
//            }
//        }
//    }

    public static <T> ArrayList<T> findAllMax(ArrayList<T> values, Comparator<T> comp) {
        T maxVal = Collections.max(values, comp);

        return new ArrayList<>(values.stream().filter((T now) -> comp.compare(now, maxVal) == 0).collect(Collectors.toList()));
    }
}
