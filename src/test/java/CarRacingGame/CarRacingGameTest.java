package CarRacingGame;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingGameTest {

    @ParameterizedTest
    @DisplayName("이름이 올바른지 확인")
    @ValueSource(strings = {"abcdef", ""})
    void 이름이_올바른지확인(String name) {
        assertThatThrownBy(() -> {
            Car car = new Car();
            car.validateName(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름을 입력하지 않은 경우")
    void 이름을_입력하지_않은_경우() {
        assertThatThrownBy(() -> {
            Car car = new Car();
            car.validateNull(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
