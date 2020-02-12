package racing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    void splitTest() {
        InputDTO input = new InputDTO("pobi,crong,honux");
        assertThat(input.getNames()).isEqualTo(Arrays.asList("pobi", "crong", "honux"));
    }
}
