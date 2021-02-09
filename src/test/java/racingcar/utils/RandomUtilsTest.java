package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomUtilsTest {

    @RepeatedTest(10)
    @DisplayName("랜덤값이 0 ~ 9 사이인지 확인")
    void between0And9() {
        int min = 0;
        int max = 9;
        int value = RandomUtils.nextInt(min, max);
        assertTrue(max >= value);
        assertTrue(min <= value);
    }
}
