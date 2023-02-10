package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"자동차", "1", "일이삼사오"})
    void 자동차_생성_성공_테스트(String name) {
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "일이삼사오육"})
    void 자동차_생성_이름길이_예외_테스트(String name) {
        assertThatThrownBy(() -> {
            new Car(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_Null_이름_예외_테스트() {
        assertThatThrownBy(() -> {
            new Car(null);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 자동차_공백이름_예외_테스트() {
        assertThatThrownBy(() -> {
            new Car("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3, Integer.MAX_VALUE})
    void 자동차_전진_테스트(int expected) {
        Car car = new Car("자동차");

        for (int i = 0; i < expected; i++) {
            car.move();
        }

        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
