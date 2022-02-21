package racingcar.util;

import static org.assertj.core.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomUtilTest {

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
