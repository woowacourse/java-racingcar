package racingcar.utils;

import java.util.Random;

/**
 * RandomUtils.java
 * 난수를 발생시키는 유틸리티 클래스
 *
 * @author 우아한 테크코스, github.com/woowacourse
 */
public class RandomUtils {
    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int nextInt(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException();
        }

        if (startInclusive < 0) {
            throw new IllegalArgumentException();
        }

        if (startInclusive == endInclusive) {
            return startInclusive;
        }

        return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
    }
}
