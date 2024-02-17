package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    void moveTest() {
        Car car = new Car("자동차1");

        car.move();

        assertThat(car.getProgress()).isEqualTo(1);
    }

    @DisplayName("이름이 공백이거나 1~5 글자 범위를 벗어날 경우 예외를 발생한다.")
    @ValueSource(strings = {"메르세데스벤츠", "", " "})
    @ParameterizedTest
    void exceededCarNameTest(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}