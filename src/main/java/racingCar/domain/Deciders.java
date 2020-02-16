package racingCar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Deciders {
    private final List<Decider> deciders;

    public Deciders(List<Integer> values) {
        deciders = values.stream()
                .map(Decider::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return deciders.size();
    }

    public List<Decider> getUnmodifiableList() {
        return Collections.unmodifiableList(deciders);
    }
}
