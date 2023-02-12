package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TrialTest {

    @ParameterizedTest
    @ValueSource(strings = {"2", "8", "20"})
    @DisplayName("Trial 생성 성공 테스트")
    void testSuccessrial(String carName) {
        new Trial(carName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㅁ", ",", "-1"})
    @DisplayName("Trial 생성 실패 테스트")
    void testFailTrial(String carName) {
        assertThatThrownBy(() -> new Trial(carName)).isInstanceOf(IllegalArgumentException.class);
    }

}
