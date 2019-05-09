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
    void 랜덤숫자가_4이상일때만_움직이는지_테스트() {
        /* Then */
        assertTrue(car.run(4));
        assertTrue(car.run(9));
        assertFalse(car.run(0));
        assertFalse(car.run(3));
    }

    @Test
    void 차가_자기_히스토리를_제대로_만드는지_테스트() {
       /* Given */
        HashMap<String, Integer> carHistory;

        /* When */
        carHistory = car.makeCarHistory();

        /* Then */
        assertThat(carHistory.containsKey("testCar")).isTrue();
        assertThat(carHistory.get("testCar")).isEqualTo(0);
    }
}