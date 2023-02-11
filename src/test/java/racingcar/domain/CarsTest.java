package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("중복 이름이 있을 때 예외가 발생한다")
    void duplicateTest() {
        Car car1 = new Car("aa");
        Car car2 = new Car("aa");

        assertThatThrownBy(() -> new Cars(List.of(car1, car2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    @DisplayName("경기에 참여하는 차가 한대일때 예외가 발생한다")
    void oneCarTest() {
        Car car1 = new Car("aa");

        assertThatThrownBy(() -> new Cars(List.of(car1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("둘 이상");
    }

    @Test
    @DisplayName("가장 큰 position 값을 가진 차가 우승한다.")
    void winTest() {
        Car car1 = new Car("a", 1);
        Car car2 = new Car("b", 2);
        Car car3 = new Car("c", 2);

        Cars cars = new Cars(List.of(car1, car2, car3));
        Winners winners = new Winners(cars.calculateWinners());

        assertThat(winners.toString())
                .contains("b")
                .contains("c")
                .doesNotContain("a");
    }
}