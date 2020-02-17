package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Name;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 자동차_이름이_빈_문자열인_경우_예외_처리() {
        String input = "";
        assertThatThrownBy(() -> {
            Name.validateEmptyName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 자동차_이름이_5자초과인_경우_예외_처리() {
        String input = "두강두강무늬무늬";
        assertThatThrownBy(() -> {
            Name.validateNameLength(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
