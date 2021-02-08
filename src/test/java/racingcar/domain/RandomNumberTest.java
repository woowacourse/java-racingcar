package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @Test
    @DisplayName("잘못된 범위 입력 예외처리")
    void random_number_make_exception() {
        assertThatThrownBy(()->RandomUtils.nextPositiveInt(10, 9)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->RandomUtils.nextPositiveInt(-3, 9)).isInstanceOf(IllegalArgumentException.class);
        assertThat(RandomUtils.nextPositiveInt(9, 9)).isEqualTo(9);
    }

}
