package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차들의 ")
class CarsTest {

    @DisplayName("이름 길이가 1000만자 이상이면 예외 발생")
    @Test
    void lengthTest() {
        assertThatThrownBy(() -> Cars.from("a".repeat(10000001)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 최대 1000만 글자여야 합니다");
    }

    @DisplayName("이름에 중복이 있으면 예외 발생")
    @Test
    void duplicateTest() {
        assertThatThrownBy(() -> Cars.from("hihi,hihi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름은 중복될 수 없습니다");
    }

    @ParameterizedTest(name = "총 길이가 1000만자 이하면 예외 발생 안함")
    @ValueSource(strings = {"abc,bd", "차이름,%!"})
    void lengthTest2(String input) {
        assertThatNoException().isThrownBy(()->Cars.from(input));
    }
}