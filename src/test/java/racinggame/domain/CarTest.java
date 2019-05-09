package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("testCar");
    }

    @Test
    void 차가_자기_히스토리를_제대로_만드는지_테스트() {
       /* Given */
        HashMap<String, Integer> carHistory;

        /* When */
        carHistory = car.makeCarHisory();

        /* Then */
        assertThat(carHistory.containsKey("testCar")).isTrue();
        assertThat(carHistory.get("testCar")).isEqualTo(0);
    }
}