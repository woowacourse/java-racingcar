package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("차량 움직임")
class CarMovementTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4보다 크거나 같은 값이 움직임이 가능한지 검증한다.")
    public void carCanMovementTest(final int numbers) {
        //given
        CarMovement carMovement = new CarMovement();

        //when
        boolean canMovable = carMovement.isMovable(numbers);

        //then
        assertTrue(canMovable);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("4보다 작은 값이 움직임이 불가능한지 검증한다.")
    public void carCantMovementTest(final int numbers) {
        //given
        CarMovement carMovement = new CarMovement();

        //when
        boolean cantMovable = carMovement.isMovable(numbers);

        //then
        assertFalse(cantMovable);
    }
}