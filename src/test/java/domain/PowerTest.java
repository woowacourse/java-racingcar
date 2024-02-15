package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 파워 테스트")
public class PowerTest {

    @DisplayName("파워가 특정 임계치를 넘어가는 경우를 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 9})
    void testSufficientPowerDetection(int powerValue) {
        Power power = Power.from(powerValue);
        assertThat(power.isSufficientPower()).isTrue();
    }

    @DisplayName("파워가 특정 임계치를 넘어가지 않는 경우를 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void testInsufficientPowerDetection(int powerValue) {
        Power power = Power.from(powerValue);
        assertThat(power.isSufficientPower()).isFalse();
    }
}
