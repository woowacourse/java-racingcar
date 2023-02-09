package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FinalRoundCheckerTest {
    FinalRoundChecker finalRoundChecker = new FinalRoundChecker(5);

    @ParameterizedTest(name = "마지막 라운드인지 확인하는 테스트")
    @CsvSource(value = {"3,false", "5,true"})
    void isFinalTest(int roundNumber, boolean isFinal) {
        assertThat(finalRoundChecker.isFinal(roundNumber)).isEqualTo(isFinal);
    }

    @Test
    @DisplayName("시도할 횟수를 초과한 자동차가 생기는 예외 검증")
    void isFinalExceptionTest() {
        assertThatThrownBy(() -> finalRoundChecker.isFinal(6)).isInstanceOf(IllegalArgumentException.class);
    }
}