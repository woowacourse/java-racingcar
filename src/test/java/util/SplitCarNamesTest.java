package util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.SplitCarNames;

public class SplitCarNamesTest {

    @Test
    @DisplayName("splitCarNames() : 매개변수로 주어진 carNames를 배열로 분리하는 기능")
    void test_splitCarNames() {
        // given
        String carNames = "pobi,crong,jay";

        // when
        String[] splitCarNames = SplitCarNames.splitCarNames(carNames);

        // then
        assertThat(splitCarNames.length).isEqualTo(3);
        assertThat(splitCarNames).containsExactly(new String[]{"pobi", "crong", "jay"});
    }
}
