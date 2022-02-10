package racingcar;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RandomUtilTest {
    @Test
    @DisplayName("0과 9사이의 숫자 랜덤 생성 테스트")
    void generateRandomNumber() {
        IntStream.range(0, 10000)
            .forEach(i -> {
                int result = RandomUtil.getNumbersInRange(10);
                assertTrue(result < 10 && result >= 0);
            });
    }
}
