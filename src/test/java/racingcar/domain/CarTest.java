package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new Racer("pobi"));
    }

    @Test
    @DisplayName("4이상의 값이 들어간 경우 전진하는지 확인")
    public void checkMoveTrue() {
        car.movePosition(4);
        Position position = car.getPosition();
        assertEquals(1, position.getPosition());
    }

    @Test
    @DisplayName("3이의 값이 들어간 경우 전진하지 않았는지 확인")
    public void checkMoveFalse() {
        car.movePosition(3);
        Position position = car.getPosition();
        assertEquals(0, position.getPosition());
    }
}
