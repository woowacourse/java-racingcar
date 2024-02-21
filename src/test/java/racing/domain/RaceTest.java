package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    @DisplayName("주어진 횟수만큼 라운드를 진행할 수 있다")
    void proceed() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");
        car2.move();
        car3.move();
        car3.move();

        Cars cars = new Cars(new ArrayList<>(List.of(car1, car2, car3)));
        int tryCount = 10;

        Race race = new Race(cars, new TryCount(tryCount));

        // when
        List<Cars> result = race.proceed();

        // then
        assertThat(result).hasSize(tryCount);
    }
}
