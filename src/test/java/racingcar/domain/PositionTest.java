package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    @DisplayName("getPosition 함수 테스트")
    @Test
    void Should_Equal_When_CompareToConstructorParameter() {
        int constructorParameter = 3;
        Position position = new Position(constructorParameter);

        assertEquals(constructorParameter, position.getPosition());
    }

    @DisplayName("moveForward 함수 테스트")
    @Test
    void Should_EqualToExpected_When_MoveForward() {
        int expectedValue = 3;
        Position position = new Position(expectedValue - 1);

        assertEquals(expectedValue, position.moveForward().getPosition());
    }

    @DisplayName("isSamePosition 함수 테스트")
    @Test
    void Should_True_When_SamePosition() {
        int value = 3;
        Position position = new Position(value);

        assertThat(position.isSamePosition(value)).isTrue();
    }
}
