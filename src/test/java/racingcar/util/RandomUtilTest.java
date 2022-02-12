package racingcar.util;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
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

    @Test
    @DisplayName("랜덤한 숫자들을 원하는 갯수에 맞게 생성한다")
    void createRandomNumbers() {
        int amount = 5;
        List<Integer> randomNumbers = RandomUtil.getRandomNumbers(amount, 10);

        assertThat(randomNumbers.size()).isEqualTo(amount);
    }

    @Test
    @DisplayName("랜덤하게 생성된 숫자들은 지정한 범위에 맞게 생성한다")
    void createRandomNumbers_LessThenEndExclusive() {
        int amount = 5;
        int endExclusive = 10;
        List<Integer> randomNumbers = RandomUtil.getRandomNumbers(amount, endExclusive);

        assertThat(randomNumbers).allMatch(number -> number < endExclusive);
    }
}
