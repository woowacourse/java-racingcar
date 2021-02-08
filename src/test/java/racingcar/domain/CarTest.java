package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new Racer("pobi"));
    }

    @Test
    public void movePosition_4_이상_전진() {
        car.movePosition(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    public void movePosition_3_이하_멈춤() {
        car.movePosition(3);
        assertEquals(0, car.getPosition());
    }
}
