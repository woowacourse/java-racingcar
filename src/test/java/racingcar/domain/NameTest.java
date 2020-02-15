package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Name;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void 자동차_이름_하나가_빈_문자열인_경우_예외_처리() {
        String inputForCarName = "";
        assertThatThrownBy(() -> {
            Name.validateEmptyName(inputForCarName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_5자초과인_경우_예외_처리() {
        String input = "두강두강무늬무늬";
        assertThatThrownBy(() -> {
            Name.validateNameLength(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
