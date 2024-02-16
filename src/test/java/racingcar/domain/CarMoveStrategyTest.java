package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("차량 이동")
class CarMoveStrategyTest {

    static class CarMoveTest implements CarMoveStrategy {
    }

    @Test
    @DisplayName("움직임에 따라 자량 이동을 검증한다.")
    public void validateCarMove() {
        //given
        int movement = 6;
        int notMovement = 1;
        CarMoveTest carMoveTest = new CarMoveTest();

        //when & then
        assertTrue(carMoveTest.isMovable(movement));
        assertFalse(carMoveTest.isMovable(notMovement));
    }
}