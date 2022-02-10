package racingcar.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InputTest {

    static Input input = new Input();

    @ParameterizedTest
    @ValueSource(strings = {" "})
    void 자동차_이름_공백_테스트(String name) {
        assertThatThrownBy(() -> {
            input.checkBlank(name, "자동차 이름은 공백일 수 없습니다.");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_개수_테스트() {
        assertFalse(input.isCars(split("pobi")));
    }

    @Test
    void 자동차_이름_중복_테스트() {
        assertTrue(input.isDuplicated(split("pobi,jun,pobi")));
    }

    @Test
    void 자동차_이름_길이_테스트() {
        assertThatThrownBy(() -> {
            input.validLength("gooddd");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_공백_테스트() {
        assertThatThrownBy(() -> {
            input.checkBlank(" ", "시는수횟도도 공백일 수 없습니다.");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_문자_예외_테스트() {
        assertFalse(input.isNumber("횟수"));
    }

    @Test
    void 시도횟수_음수_테스트() {
        assertTrue(input.isNegative("-1"));
    }

    String[] split(String text) {
        return text.split(",");
    }
}