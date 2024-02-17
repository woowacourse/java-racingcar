package util;

import java.util.Random;

public class NumberGenerator {
    public static Integer generate(final Integer value) {
        return new Random().nextInt(value);
    }
}
