package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class CarTest {
    public Car car;

    @BeforeEach
    public void beforeEach() {
        car = new Car("클레이");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 자동차_멈춤_테스트(int input) {
        car.tryMoving(input);
        assertThat(car.getCarPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 자동차_전진_테스트(int input) {
        car.tryMoving(input);
        assertThat(car.getCarPosition()).isEqualTo(1);
    }
}