package util;

import java.util.Objects;

public class RandomNumberGenerator implements NumberGenerator {

    private static RandomNumberGenerator randomNumberGenerator;

    public static int getRandomNumber(int startInclusive, int endInclusive) {
        if (Objects.isNull(randomNumberGenerator)) {
            randomNumberGenerator = new RandomNumberGenerator();
        }
        return randomNumberGenerator.generate(startInclusive, endInclusive);
    }

    @Override
    public int generate(int startInclusive, int endInclusive) {
        if (!(startInclusive <= endInclusive)) {
            throw new IllegalArgumentException("시작범위는 마지막 범위 이하여야 합니다.");
        }
        return startInclusive + (int) (Math.random() * (endInclusive - startInclusive));
    }
}
