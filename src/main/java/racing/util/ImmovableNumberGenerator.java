package racing.util;

import static racing.domain.Car.MIN_FORWARD_CONDITION;

public class ImmovableNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return MIN_FORWARD_CONDITION - 1;
    }
}
