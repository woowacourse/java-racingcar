package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;

public class CarsTest {
    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 자동차의_이름들이_빈_문자열인_경우_예외_처리() {
        String input = "";
        assertThatThrownBy(() -> {
            Cars.validateNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 자동차의_이름이_중복되는_경우_예외_처리() {
        String input = "무늬, 무늬,  무늬 ";
        assertThatThrownBy(() -> {
           Cars.validateDuplicatedNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
