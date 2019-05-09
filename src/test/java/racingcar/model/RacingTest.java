package racingcar.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Racing;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingTest {

    Racing racing;
    Car car;
    @BeforeEach
    void setUp() {
        car = new Car("pobi");
        racing = new Racing();
    }

    @Test
    void 이동이_잘되는지_테스트() {
//        assertFalse(racing.move(car,0));
//        assertFalse(racing.move(car,1));
//        assertFalse(racing.move(car,2));
//        assertFalse(racing.move(car,3));
//
//        assertTrue(racing.move(car,4));
//        assertTrue(racing.move(car,5));
//        assertTrue(racing.move(car,6));
//        assertTrue(racing.move(car,7));
//        assertTrue(racing.move(car,8));
//        assertTrue(racing.move(car,9));
    }

    @AfterEach
    void tearDown() {
        car = null;
        racing = null;
    }
}
