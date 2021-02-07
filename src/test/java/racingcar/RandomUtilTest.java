package racingcar;

import org.junit.jupiter.api.RepeatedTest;
import racingcar.utils.RandomUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {
    @RepeatedTest(50)
    void checkRandomNumber() {
        int randomNumber = RandomUtil.nextInt(0,9);
        assertThat(-1 < randomNumber && randomNumber < 10).isTrue();
    }
}
