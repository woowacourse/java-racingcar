package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

public class RangedRandomNumberPickerTest {

    final int FROM = 0;
    final int TO = 9;

    @RepeatedTest(100)
    void 범위내의_무작위_숫자를_뽑을_수_있다() {
        // given
        RangedRandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(FROM, TO);

        // when
        int result = randomNumberPicker.pickRandomNumber();

        // then
        assertThat(result).isGreaterThanOrEqualTo(FROM).isLessThanOrEqualTo(TO);
    }
}
