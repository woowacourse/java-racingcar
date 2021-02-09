package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RoundTest {
    @DisplayName("라운드가 음수일 때 에러가 나는지")
    @Test
    void 라운드가_음수이면_에러() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingGame(Arrays.asList("똘이", "똘순"), -1));
    }
}
