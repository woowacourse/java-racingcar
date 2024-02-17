package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.CarNames;

class CarNamesTest {


    @DisplayName("구분자로 끝날 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,,", ","})
    void invalidSeparator(String value) {
        assertThatThrownBy(() -> CarNames.from(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구분자로 끝날 수 없습니다.");
    }

    @DisplayName("자동차 이름이 중복시 예외 발생")
    @Test
    void duplicatedName() {
        assertThatThrownBy(() -> CarNames.from("aa,aa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 이름이 존재합니다.");
    }

    @DisplayName("자동차 이름이 콤마로 구분되어 정상적으로 생성된다.")
    @Test
    void from() {
        final CarNames carNames = CarNames.from("a,b,c,d");

        assertThat(carNames.getCarNames())
                .extracting("name")
                .containsExactly("a", "b", "c", "d");

    }
}
