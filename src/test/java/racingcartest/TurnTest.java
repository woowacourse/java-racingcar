package racingcartest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.Checker;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TurnTest {
    Checker checker = new Checker();

    @ParameterizedTest
    @ValueSource(strings = {"", "ab", "-100"})
    public void turnTest(String input) {
        assertThat(checker.checkTurnConditions(input)).contains("[ERROR]");
    }

    @Test
    public void turnNullTest() {
        assertThat(checker.checkTurnConditions(null)).contains("[ERROR]");
    }
}
