package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.name.CarName;
import racing.domain.name.CarNames;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatCode;

class CarsTest {
    @DisplayName("Cars의 변수로 할당될 Car객체가 하나인경우 에러가 발생한다")
    @Test
    void Cars_1명인_경우_예외가_발생한다() {
        CarNames carNames = CarNames.of(Collections.singletonList(new CarName("pobi")));
        assertThatCode(() -> {
            Cars.generate(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차는 1개 이상이어야 합니다");
    }
}