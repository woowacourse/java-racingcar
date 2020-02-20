package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class CarsTest {
    @Test
    void 자동차의_이름들이_빈_문자열인_경우_예외_처리() {
        String input = "";
        assertThatThrownBy(() -> {
            Cars.validateNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차의_이름이_중복되는_경우_예외_처리() {
        String input = "무늬, 무늬,  무늬 ";
        assertThatThrownBy(() -> {
            Cars.validateDuplicatedNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
