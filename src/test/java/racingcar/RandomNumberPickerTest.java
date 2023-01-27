package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RandomNumberPickerTest {
    final int FROM = 0;
    final int TO = 9;

    @RepeatedTest(10)
    void 범위내의_무작위_숫자를_뽑을_수_있다() {
        // given
        RandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(FROM, TO);

        // when
        int result = randomNumberPicker.pickNumber();

        // then
        assertThat(result).isGreaterThanOrEqualTo(FROM).isLessThanOrEqualTo(TO);
    }
}
