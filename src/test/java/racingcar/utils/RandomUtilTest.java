package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.utils.RandomUtil;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤 숫자 생성 테스트")
public class RandomUtilTest {
    @DisplayName("생성된 랜덤 숫자 범위 테스트")
    @RepeatedTest(50)
    void randomNumberRangeTest() {
        int randomNumber = RandomUtil.generateRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }
}
