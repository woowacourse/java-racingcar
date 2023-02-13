package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.CarService;

class CarTest {
    @Nested
    @DisplayName("전진 테스트")
    class TestForward {
        CarService carService = new CarService();
        Car car = new Car("test", 0);
        Position position = car.getPosition();

        @ParameterizedTest(name = "{index} ==> Distance : ''{0}''")
        @ValueSource(ints = {0, 2})
        @DisplayName("랜덤 값이 4보다 작은 경우 멈춤")
        void Should_Success_랜덤값이_4보다_작은_경우(int number) {
            carService.runForward(car, number);
            assertThat(position.getPosition()).isEqualTo(0);
        }

        @ParameterizedTest(name = "{index} ==> Distance : ''{0}''")
        @ValueSource(ints = {4, 7})
        @DisplayName("랜덤 값이 4 이상인 경우 전진")
        void Should_Success_랜덤값이_4이상인_경우(int number) {
            carService.runForward(car, number);
            assertThat(position.getPosition()).isEqualTo(1);
        }
    }
}
