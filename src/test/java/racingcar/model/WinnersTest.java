package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class WinnersTest {
    @Test
    void 비어있지_않음() {
        // given
        String name1 = "오찌";
        String name2 = "연로그";
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);

        cars.add(car1);
        cars.add(car2);

        // when
        Winners winners = new Winners(cars);

        // then
        assertThat(winners.getNames()).contains(name1, name2);
    }
}