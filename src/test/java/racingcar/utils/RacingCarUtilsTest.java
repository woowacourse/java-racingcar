package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RacingCarUtilsTest {
    @ParameterizedTest
    @DisplayName("자동차 이름을 `,` 로 구분 하기")
    @ValueSource(strings = "pobi,amazzi,fortune")
    void splitString(String inputString) {
        String result = RacingCarUtils.splitInputString(inputString).toString();
        assertThat(result.equals(Arrays.asList("pobi", "amazzi", "fortune").toString())).isTrue();
    }
}
