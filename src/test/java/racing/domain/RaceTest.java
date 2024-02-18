package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    private Cars cars;

    @BeforeEach
    public void setUp() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");
        car2.move();
        car3.move();
        car3.move();
        cars = new Cars(new ArrayList<>(List.of(car1, car2, car3)));
    }

    @Test
    @DisplayName("주어진 횟수만큼 라운드를 진행할 수 있다")
    void proceed() {
        int tryCount = 10;
        Race race = new Race(cars, new TryCount(tryCount));
        List<Cars> result = race.proceed();
        assertThat(result).hasSize(tryCount);
    }
}
