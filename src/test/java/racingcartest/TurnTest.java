package racingcartest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TurnTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "ab", "-100"})
    public void turnTest(String input) {
        assertThatThrownBy(() -> InputView.checkTurnError(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

    @Test
    public void turnNullTest() {
        assertThatThrownBy(() -> InputView.checkTurnError(null)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }
}
