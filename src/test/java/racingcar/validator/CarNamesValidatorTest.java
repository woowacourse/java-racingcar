package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.Cars;

@SuppressWarnings("NonAsciiCharacters")
public class CarNamesValidatorTest {

    @Test
    void 자동차_이름_중복() {
        String[] carNames = {"aa", "bb", "aa"};
        assertThatThrownBy(() -> new Cars(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 자동차_이름_5자_초과() {
        assertThatThrownBy(() -> new Car("ccccccc"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 자동차 이름은 5자 미만이어야 합니다.");
    }

    @Test
    void 자동차_이름_공백() {
        assertThatThrownBy(() -> new Car("   "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 자동차 이름은 공백이 될 수 없습니다.");
    }

    @Test
    void 자동차_이름_입력X() {
        assertThatThrownBy(() -> new Car(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 자동차 이름은 공백이 될 수 없습니다.");
    }
}
