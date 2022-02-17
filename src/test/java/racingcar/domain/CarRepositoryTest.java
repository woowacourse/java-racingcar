package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRepositoryTest {
    @Test
    @DisplayName("중복된 자동차 이름을 입력한 경우 예외 발생")
    void carNameMustNotDuplicated() {
        String[] carNames = {"woo", "te", "co", "woo"};

        assertThatThrownBy(() -> new CarRepository(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
