package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputViewTest {
    @Test
    void filterTyposTest1() {
        assertThat(InputView.filterTypos("a, b, c")).isEqualTo(Arrays.asList("a", "b", "c"));
    }

    @Test
    void filterTyposTest2() {
        assertThat(InputView.filterTypos("a,,, b, c")).isEqualTo(Arrays.asList("a", "b", "c"));
    }

    @Test
    void filterTyposTest3() {
        assertThat(InputView.filterTypos("a,  ,   b  , c")).isEqualTo(Arrays.asList("a", "b", "c"));
    }
}