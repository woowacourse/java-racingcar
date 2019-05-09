package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MoveStrategyTest {

    private MoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {

    }

    @Test
    void isMove_4이상일때_참인지() {
        // Arrange
        IntStream validRandValues = IntStream.of(4, 5, 6, 7, 8, 9);

        validRandValues.forEach((v) -> {
            // Arrange
            Random mockedRand = mock(Random.class);
            when(mockedRand.nextInt(MoveStrategy.MAX_NUM)).thenReturn(v);
            moveStrategy = new MoveStrategy(mockedRand);

            // Act
            boolean actual = moveStrategy.isMove();

            // Assert
            assertTrue(actual, String.format("v: %d", v));
        });
    }

    @Test
    void isMove_3이하일때_거짓인지() {
        // Arrange
        IntStream validRandValues = IntStream.of(0, 1, 2, 3);

        validRandValues.forEach((v) -> {
            // Arrange
            Random mockedRand = mock(Random.class);
            when(mockedRand.nextInt(MoveStrategy.MAX_NUM)).thenReturn(v);
            moveStrategy = new MoveStrategy(mockedRand);

            // Act
            boolean actual = moveStrategy.isMove();

            // Assert
            assertFalse(actual);
        });
    }
}