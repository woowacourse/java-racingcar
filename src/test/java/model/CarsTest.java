package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 자동차_이름_리스트로_자동차_리스트를_생성한다() {
        Cars cars = Cars.fromNames(List.of("pobi", "dora"));
        assertThat(cars.getClass()).isEqualTo(Cars.class);
    }

    @Test
    void 중복된_자동차_이름이_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Cars.fromNames(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차가_한_대_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> Cars.fromNames(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
