package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤")
class RandomNumberTest {
    @Test
    @DisplayName("해당 범위의 난수값이 나오는지 검증한다.")
    public void testRandomRange() {
        //given
        final int MIN_RANGE = 0;
        final int MAX_RANGE = 10;

        //when
        RandomNumber random = RandomNumber.getInstance();

        //then
        assertThat(random.generate(MIN_RANGE, MAX_RANGE))
                .isBetween(MIN_RANGE, MAX_RANGE);
    }
}