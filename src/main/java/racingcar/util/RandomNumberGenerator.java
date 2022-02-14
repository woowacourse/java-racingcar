package racingcar.util;

import java.util.Random;

public interface RandomNumberGenerator {
    Random random = new Random();

    int generate();
}
