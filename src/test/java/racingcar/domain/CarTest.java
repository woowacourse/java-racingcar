package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @ParameterizedTest(name = "자동차 이름 검증 테스트 - 입력이름 : \"{0}\"")
    @ValueSource(strings = {"abcdef", "", "   a   "})
    void carNameExceptionTest(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}