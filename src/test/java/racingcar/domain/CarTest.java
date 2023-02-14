package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
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

    @Nested
    @DisplayName("우승자 반환 테스트")
    class TestWinner {
        CarService carService = new CarService();
        Cars cars = new Cars(new ArrayList<Car>());

        @Test
        @DisplayName("가장 위치 값이 큰 사람이 1명일 때, 1명의 우승자를 반환한다.")
        void Should_Success_우승자가_1명인_경우() {
            cars.addCar(new Car("pobi", 0));
            cars.addCar(new Car("neo", 0));
            carService.runForward(cars.getCars().get(0), Car.FORWARD_BOUNDARY);
            assertThat(cars.getWinner()).containsExactly("pobi");
        }

        @Test
        @DisplayName("가장 위치 값이 큰 사람이 2명일 때, 2명의 우승자를 반환한다.")
        void Should_Success_우승자가_2명인_경우() {
            cars.addCar(new Car("pobi", 0));
            cars.addCar(new Car("neo", 0));
            assertThat(cars.getWinner()).containsExactly("pobi", "neo");
        }
    }
}
