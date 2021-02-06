package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {
    @DisplayName("Round 생성 메소드 인자 범위 검증 테스트 - 양의 정수만 허용")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void roundConstructorExceptionTest(int endRound) {
        assertThatThrownBy(() -> Round.from(endRound)).isInstanceOf(IllegalArgumentException.class);
    }
}