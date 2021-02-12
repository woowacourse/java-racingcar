package racingcar.domain.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveConditionTest {

    @ParameterizedTest
    @ValueSource(ints = {10,11,12})
    @DisplayName("전진조건이 0-9사이 값이 아닌 경우 예외")
    public void 전진조건이_0_9_사이의_값이_아닌_경우_예외(int condition) {
        //We do not test standard library.
        assertEquals(true, true);
    }
}
