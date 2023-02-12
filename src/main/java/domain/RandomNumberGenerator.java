package domain;

import java.util.Random;

// TODO 클래스명 검토. 도메인에 맞는 값을 반환하는 것인지 유틸성 클래스인지?
public class RandomNumberGenerator implements NumberGenerator {

    private static final int POWER_VALUE_MIN = 0;
    private static final int POWER_VALUE_MAX = 9;

    private final Random random = new Random();

    @Override
    public int generate() {
        return POWER_VALUE_MIN + random.nextInt(POWER_VALUE_MAX + 1);
    }
}
