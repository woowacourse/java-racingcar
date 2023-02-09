package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FinalRoundCheckerTest {
    FinalRoundChecker finalRoundChecker = new FinalRoundChecker(5);

    @ParameterizedTest
    @CsvSource(value = {"3,false", "5,true"})
    void isFinalTest(int roundNumber, boolean isFinal) {
        assertThat(finalRoundChecker.isFinal(roundNumber)).isEqualTo(isFinal);
    }

    @Test
    void isFinalExceptionTest() {
        assertThatThrownBy(() -> finalRoundChecker.isFinal(6)).isInstanceOf(IllegalArgumentException.class);
    }
}