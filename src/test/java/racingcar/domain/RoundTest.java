package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"ㄱ", "a", "0", "!"})
    @DisplayName("round 인스턴스를 생성할 때 시도 횟수를 검증하는 테스트")
    void roundGenerateTest(String input) {
        //When + Then
        assertThatThrownBy(() -> new Round(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
