package racingcar.util;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    @DisplayName("지정한 범위 내의 숫자만 생성되는지 테스트")
    @RepeatedTest(100)
    void pickNumberInRangeTest() {
        int min = 3;
        int max = 4;
        int numberInRange = RandomNumberGenerator.pickNumberInRange(min, max);

        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(numberInRange).isGreaterThanOrEqualTo(min);
            softAssertions.assertThat(numberInRange).isLessThanOrEqualTo(max);
        });
    }
}
