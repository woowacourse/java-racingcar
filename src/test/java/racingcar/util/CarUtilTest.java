package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarUtilTest {
    public static final int MIN = 0;
    public static final int MAX = 9;

    @Test
    @DisplayName("0~9사이의 수가 잘 생성되는 지")
    public void randomNumberTest() {
        assertThat(CarUtil.random() >= MIN && CarUtil.random() <= MAX).isTrue();
    }
}
