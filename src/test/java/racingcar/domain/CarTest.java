package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "jun"})
    void 자동차_생성자_검증_성공(String name) {
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 자동차_위치_검증_성공() {
        Car car = new Car("pobi", 4);
        assertThat(car.checkIfPositionSame(4)).isTrue();
    }

    @Test
    void 자동차_위치_검증_실패() {
        Car car = new Car("pobi", 4);
        assertThat(car.checkIfPositionSame(6)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:False", "1:False", "2:False", "3:False", "4:True", "5:True", "6:True", "7:True", "8:True", "9:True"}, delimiter = ':')
    void 랜덤값_전진_검증(int value, boolean expected) {
        Car car = new Car("pobi", 0);
        car.goForward(value);
        assertThat(car.checkIfPositionSame(1)).isEqualTo(expected);
    }
}
