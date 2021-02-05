package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new Name("pobi"));
    }

    @Test
    public void movePosition_4_이상_전진() {
        car.movePosition(4);
        assertEquals(true, car.hasSamePositionWith(1));
    }

    @Test
    public void movePosition_3_이하_멈춤() {
        car.movePosition(3);
        assertEquals(true, car.hasSamePositionWith(0));
    }
}
