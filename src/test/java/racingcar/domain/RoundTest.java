package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundTest {
    @DisplayName("Round 생성 메소드 인자 범위 검증 테스트 - 양의 정수만 허용")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void roundConstructorExceptionTest(int endRound) {
        assertThatThrownBy(() -> Round.from(endRound)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Round 진행 회수에 따른 종료 여부 리턴 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:3:false", "2:3:false", "3:3:true"}, delimiter = ':')
    void roundProceedTest(int currentRound, int finalRound, boolean expected) {
        int currentRoundNumber = Integer.parseInt(currentRound);
        int finalRoundNumber = Integer.parseInt(finalRound);

        Round round = Round.from(finalRoundNumber);
        for (int i = 0; i < currentRoundNumber; i++) {
            round.nextRound();
        }

        assertEquals(round.isEnd(), Boolean.parseBoolean(expected));
    }
}
