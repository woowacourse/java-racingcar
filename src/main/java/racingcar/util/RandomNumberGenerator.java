package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random RANDOM = new Random();

    private RandomNumberGenerator() {
        // 인스턴스 생성 방지용
    }

    public static int generate(final int max) {
        return RANDOM.nextInt(max + 1); // bound 미만의 숫자를 return하기 때문에 +1
    }
}
