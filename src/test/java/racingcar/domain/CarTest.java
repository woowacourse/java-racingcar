package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    Car car = new Car("test");

    @ParameterizedTest(name = "{displayName} {index} ==> engine : ''{0}''")
    @ValueSource(ints = {0, 2, 3})
    @DisplayName("4보다 작은 경우 멈춤")
    void Should_Success_When_EngineLessThan4(int engine) {
        car.runForward(engine);
        assertThat(car.getDistance().getValue()).isEqualTo(0);
    }

    @ParameterizedTest(name = "{displayName} {index} ==> engine : ''{0}''")
    @ValueSource(ints = {4, 7, 10})
    @DisplayName("4 이상인 경우 전진")
    void Should_Success_When_EngineMoreThan4(int engine) {
        car.runForward(engine);
        assertThat(car.getDistance().getValue()).isEqualTo(1);
    }
}
