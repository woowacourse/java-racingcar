package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("범위 난수 생성 테스트")
class PowerManagerTest {

    @DisplayName("생성된 난수는 지정된 범위를 벗어나지 않는다")
    @RepeatedTest(50)
    void testRangeOfRandomNumber() {
        PowerManager powerManager = new PowerManager();
        int randomNumber = powerManager.generatePower();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @DisplayName("생성된 파워가 임계값 이상인 경우 파워는 충분하다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9})
    void testSufficiencyOfValidPower(int power) {
        PowerManager powerManager = new PowerManager();
        assertThat(powerManager.isSufficientPower(power)).isTrue();
    }

    @DisplayName("생성된 파워가 임계값 미만인 경우 파워는 충분하지 않다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    void testSufficiencyOfInvalidPower(int power) {
        PowerManager powerManager = new PowerManager();
        assertThat(powerManager.isSufficientPower(power)).isFalse();
    }
}