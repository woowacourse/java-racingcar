package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @Test
    @DisplayName("자동차 생성")
    public void create() {
        // given
        String name = "test1";

        // when
        Car car = new Car(name);

        // then
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456", " "})
    @DisplayName("자동차 생성 실패")
    public void createFail(String name) {
        // then
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:1", "3:0"}, delimiter = ':')
    @DisplayName("자동차 이동")
    public void go(int input, int expect) {
        // given
        Car car = new Car("test");

        // when
        car.go(input);

        // then
        assertThat(car.getPosition()).isEqualTo(expect);
    }

}