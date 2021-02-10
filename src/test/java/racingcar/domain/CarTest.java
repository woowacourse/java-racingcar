package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new Racer("pobi"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4이상의 값이 들어간 경우 전진하는지 확인")
    public void checkMoveTrue(int number) {
        MoveStrategy moveStrategy = () -> number;
        car.move(moveStrategy);
        Position position = car.getPosition();
        assertEquals(1, position.getPosition());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("3이하의 값이 들어간 경우 전진하지 않았는지 확인")
    public void checkMoveFalse(int number) {
        MoveStrategy moveStrategy = () -> number;
        car.move(moveStrategy);
        Position position = car.getPosition();
        assertEquals(0, position.getPosition());
    }
}
