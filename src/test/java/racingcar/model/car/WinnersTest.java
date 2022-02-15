package racingcar.model.car;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.Winners;

@SuppressWarnings("NonAsciiCharacters")
class WinnersTest {
    String name1 = "오찌";
    String name2 = "연로그";

    private Car car1;
    private Car car2;

    private List<Car> cars;

    @BeforeEach
    public void 자동차_생성() {
        cars = new ArrayList<>();

        car1 = new Car(name1);
        car2 = new Car(name2);

        cars.add(car1);
        cars.add(car2);
    }

    @Test
    public void 우승자_1명() {
        // given
        car1.goOrStop(4);

        // when
        Winners winners = new Winners(cars);

        // then
        assertThat(winners.getNames()).containsOnly(name1);
    }

    @Test
    public void 공동우승() {
        // given
        car1.goOrStop(4);
        car2.goOrStop(4);

        cars.add(car1);
        cars.add(car2);

        // when
        Winners winners = new Winners(cars);

        // then
        assertThat(winners.getNames()).contains(name1, name2);
    }
}