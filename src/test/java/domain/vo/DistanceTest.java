package domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class DistanceTest {

    @Test
    void 거리_값에_해당하는_값_객체이다() {
        // given
        int value = 10;

        // when
        Distance distance = new Distance(value);

        // then
        assertThat(distance).isEqualTo(new Distance(10));
    }

    @Test
    void 음수를_가질_수_있다() {
        // given
        int value = -10;

        // when
        // then
        assertThatNoException().isThrownBy(() -> new Distance(value));
    }

    @Test
    void 입력_값만큼_값을_추가한다() {
        // given
        Distance distance = new Distance(10);
        int value = 10;

        // when
        Distance result = distance.plus(value);

        // then
        assertThat(result.value()).isEqualTo(20);
    }

    @Test
    void 초기값은_0부터_시작한다() {
        // when
        Distance distance = Distance.initial();

        // then
        assertThat(distance.value()).isEqualTo(0);
    }
}
