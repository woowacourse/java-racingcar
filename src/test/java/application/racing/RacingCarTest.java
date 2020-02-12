package application.racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {
    @Test
    public void splitTest() {
        String input = ",abc";
        String[] expected = {"", "abc"};
        Assertions.assertThat(input.split(",")).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", ",asd", "asdfrq,pobi", "pobi,pobi", "pobi,,crong", "pobi, ,crong"})
//    @ValueSource(strings = {",asd"})
    public void validateInputCarNameTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            CarName carName = new CarName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
