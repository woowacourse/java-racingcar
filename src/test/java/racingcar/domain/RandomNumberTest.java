package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomUtils;

public class RandomNumberTest {

    @Test
    @DisplayName("지정된 범위의 난수 생성")
    void random_number_make() {
        final int minimumNumber = 0;
        final int maximumNumber = 9;
        for (int i = 0; i < 999999; i++) {
            int madeNumber = RandomUtils.nextPositiveInt(maximumNumber, maximumNumber);
            assertThat(madeNumber).isBetween(minimumNumber, maximumNumber);
        }
    }
}
