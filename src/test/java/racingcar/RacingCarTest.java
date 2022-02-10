package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @Test
    @DisplayName("이름들을 쉼표로 분리하는 테스트")
    void commaSplitNameTest() {
        String names = "pobi,crong,honux";
        String[] namesArray = RacingCar.splitNames(names);
        Assertions.assertThat(namesArray).containsExactly("pobi", "crong", "honux");
    }
}
