package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {
    @Test
    @DisplayName("공동 우승자")
    void many() {
        // given
        String name1 = "오찌";
        String name2 = "연로그";

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(name1));
        cars.add(new Car(name2));

        // when
        Winners winners = new Winners(cars);

        // then
        assertThat(winners.getNames())
                .contains(name1, name2);
    }

    @Test
    @DisplayName("우승자 1명")
    void one() {
        // given
        String name1 = "오찌";
        String name2 = "연로그";

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(name1));

        Car car1 = new Car(name2);
        car1.goOrStop(6);
        cars.add(car1);

        // when
        Winners winners = new Winners(cars);

        // then
        assertThat(winners.getNames())
                .doesNotContain(name1);
    }

    @Test
    @DisplayName("maxPosition 구하기")
    void maxPosition() {
        // given
        List<Car> cars = new ArrayList<>();
        Car car = new Car("연로그");
        car.goOrStop(6);
        car.goOrStop(6);
        cars.add(car);

        // when
        Winners winners = new Winners(cars);

        // then
        assertThat(winners.getMaxPosition()).isEqualTo(2);
    }
}