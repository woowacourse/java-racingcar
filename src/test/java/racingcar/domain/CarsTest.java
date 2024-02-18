package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
import racingcar.domain.numbergenerator.NumberGenerator;

class CarsTest {

    @DisplayName("자동차 이름이 중복시 예외 발생")
    @Test
    void duplicatedName() {
        assertThatThrownBy(() -> Cars.from(List.of(new CarName("aa"), new CarName("aa"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 이름이 존재합니다.");
    }

    @DisplayName("자동차가 자동차 이름 리스트로 생성된다.")
    @Test
    void from() {
        final CarName carNameA = new CarName("a");
        final CarName carNameB = new CarName("b");
        final CarName carNameC = new CarName("c");
        final CarName carNameD = new CarName("d");
        final Cars cars = Cars.from(List.of(carNameA, carNameB, carNameC, carNameD));

        assertThat(cars)
                .extracting("cars")
                .isEqualTo(List.of(new Car(carNameA), new Car(carNameB), new Car(carNameC), new Car(carNameD)));
    }

    @DisplayName("공동 우승자 확인")
    @Test
    void findWinners() {
        // given
        Cars cars = Cars.from(List.of(new CarName("a"), new CarName("b"), new CarName("c")));
        cars.go(() -> 5);

        // when
        List<String> winner = cars.findWinners();

        // then
        assertThat(winner).hasSize(3);
    }

    @DisplayName("단독 우승자 확인")
    @Test
    void findWinner() {
        // given
        Cars cars = Cars.from(List.of(new CarName("a"), new CarName("b"), new CarName("c")));
        cars.go(new TestNumberGenerator());

        // when
        List<String> winner = cars.findWinners();

        // then
        assertThat(winner).hasSize(1).isEqualTo(List.of("c"));
    }


    static class TestNumberGenerator implements NumberGenerator {

        private static int value = 2;
        @Override
        public int generate() {
            return value++;
        }
    }
}
