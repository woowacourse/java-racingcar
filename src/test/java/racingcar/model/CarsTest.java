package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    @DisplayName("생성 성공")
    public void success() {
        // given
        String names = "오찌,연로그";

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("중복_체크")
    public void duplicated() {
        // given
        String names = "오찌,연로그,연로그";

        // when
        // then
        assertThatThrownBy(() -> new Cars(names)).isInstanceOf(IllegalArgumentException.class);
    }

}