package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName("자동차 객체의 유효한 이름 형식은 5자 이하의 영어로 구성된다.")
    @Test
    void makeCar() {
        assertThatCode(() -> {
            Car car = new Car("pobi");
            String name = car.getName();

            assertThat(name).isEqualTo("pobi");
        }).doesNotThrowAnyException();
    }

    @DisplayName("자동차 객체의 이름이 null, 빈문자열, 영어가 아닌 문자 포함, 6자 이상의 영문자인 경우 생성 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcdef", "ab.de", "   "})
    void cannotMakeCar(String name) {
        assertThatThrownBy(() -> {
            new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 문자열이 아닌 5자 이하의 영어로 구성되어야 합니다.");
    }
}
