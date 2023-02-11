package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest(name = "자동차 이름 검증 테스트 - 입력이름 : \"{0}\"")
    @ValueSource(strings = {"abcdef", "", "   a   "})
    void carNameExceptionTest(String name) {
        assertThatThrownBy(() -> new Car(name))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이동에 대한 테스트")
    void moveTest() {
        Car car = new Car("test");
        car.move(4);
        int firstPosition = car.getPosition();
        car.move(5);
        int secondPosition = car.getPosition();
        car.move(3);
        assertSoftly(softly -> {
            softly.assertThat(firstPosition).isEqualTo(1);
            softly.assertThat(secondPosition).isEqualTo(2);
        });
    }

    @ParameterizedTest(name = "자동차 이동의 예외에 대한 테스트")
    @ValueSource(ints = {-1, 10})
    void moveExceptionTest(int value) {
        assertThatThrownBy(() -> new Car("test").move(value)).isInstanceOf(IllegalArgumentException.class);
    }
}