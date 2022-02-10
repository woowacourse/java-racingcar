package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @DisplayName("차 이름이 정상적으로 입력됬을 때 정상적으로 생성된다.")
    @Test
    void constructor_정상() {
        // given
        String input = "pobi";

        // when & then
        assertThatCode(() -> {
            new CarName(input);
        }).doesNotThrowAnyException();
    }

    @DisplayName("차 이름이 null인 경우 예외를 던진다.")
    @Test
    void constructor_이름널() {
        // given
        String input = null;

        // when & then
        assertThatThrownBy(() -> {
            new CarName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차 이름이 비어있는 경우 예외를 던진다.")
    @Test
    void constructor_empty() {
        // given
        String input = "";

        // when & then
        assertThatThrownBy(() -> {
            new CarName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차 이름이 공백인 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "   "})
    void constructor_blank(String input) {
        // given & when & then
        assertThatThrownBy(() -> {
            new CarName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차 이름의 길이가 5자를 초과하는 경우 예외를 던진다.")
    @Test
    void constructor_차길이() {
        // given
        String input = "매트매트매트";

        // when & then
        assertThatThrownBy(() -> {
            new CarName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}