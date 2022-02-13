package racingcar.model.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class CarsTest {
    @Test
    public void 생성_성공() {
        // given
        String names = "오찌,연로그";

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars).isNotNull();
    }

    @Test
    public void 중복_체크() {
        // given
        String names = "오찌,연로그,연로그";

        // when
        // then
        assertThatThrownBy(() -> new Cars(names)).isInstanceOf(IllegalArgumentException.class);
    }
}