package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomUtilTest {
    @Test
    @DisplayName("0과 9사이의 숫자 랜덤 생성 테스트")
    void generateRandomNumber() {
        IntStream.range(0, 10000)
            .forEach(i -> {
                int result = RandomUtil.getNumbersInRange(10);
                assertThat(result < 10 && result >= 0).isTrue();
            });
    }
}
