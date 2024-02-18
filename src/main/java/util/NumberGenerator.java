package util;

import java.util.Random;
//TODO 도메인으로 설계해보기
public class NumberGenerator {
    public static Integer generate(final Integer value) {
        return new Random().nextInt(value);
    }
}
