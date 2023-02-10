package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class ValueLog {

    private List<Integer> log = new ArrayList<>();

    public void add(int value) {
        log.add(value);
    }

    public int size() {
        return log.size();
    }

    public int stepNumber(int threshold) {
        return (int) log.stream().filter(value -> value >= threshold).count();
    }
}
