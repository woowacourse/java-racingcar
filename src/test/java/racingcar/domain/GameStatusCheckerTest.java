package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.dto.NumberOfRoundsRequestDTO;

class GameStatusCheckerTest {
    GameStatusChecker gameStatusChecker = new GameStatusChecker(new NumberOfRoundsRequestDTO(5));

    @ParameterizedTest(name = "게임이 진행중인지 확인하는 테스트")
    @CsvSource(value = {"3,true", "5,false"})
    void isOngoingTest(int currentRound, boolean isOngoing) {
        assertThat(gameStatusChecker.isOngoing(currentRound)).isEqualTo(isOngoing);
    }

    @Test
    @DisplayName("전체 라운드 수를 초과한 턴을 가진 자동차가 생기는 예외 검증")
    void isOngoingExceptionTest() {
        assertThatThrownBy(() -> gameStatusChecker.isOngoing(6)).isInstanceOf(IllegalArgumentException.class);
    }
}