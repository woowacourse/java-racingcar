package racingGame.domain.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundsTest {
    @DisplayName("양의 정수가 아닌 수가 시도 횟수로 입력된 경우")
    @ParameterizedTest
    @ValueSource(ints = {-1})
    void expectInvalidRangeException(int inputNumber) {
        assertThatThrownBy(() -> {
            Rounds.create(inputNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 정수가 시도 횟수로 입력된 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 34})
    void checkInstanceWithValidInput(int inputNumber) {
        Rounds.create(inputNumber);
    }

    @DisplayName("Rounds의 종료 기능 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8})
    void checkIsEnd(int expectRounds) {
        Rounds mockRounds = Rounds.create(expectRounds);
        int thisRound = 0;

        while (!mockRounds.isEnd()) {
            mockRounds.next();
            thisRound++;
        }

        assertThat(thisRound).isEqualTo(expectRounds);
    }
}