package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.provider.TestProvider.createTestRace;

public class RaceTest {

    @Test
    @DisplayName("사용자가 입력한 횟수만큼 경주를 진행했다면 false를 리턴한다.")
    void givenRaceOrder_thenReturnTrue() {
        // given
        String userRaceCount = "3";
        Race testRace = createTestRace(userRaceCount);

        // when
        boolean isRaceFinish = testRace.isRunning(Integer.parseInt(userRaceCount));

        // then
        assertThat(isRaceFinish)
                .isFalse();
    }

    @Test
    @DisplayName("사용자가 입력한 횟수만큼 경주를 진행하지 않았다면 true를 리턴한다.")
    void givenRaceOrder_thenReturnFalse() {
        // given
        String userRaceCount = "3";
        Race testRace = createTestRace(userRaceCount);
        int raceCount = 2;

        // when
        boolean isRaceFinish = testRace.isRunning(raceCount);

        // then
        assertThat(isRaceFinish)
                .isTrue();
    }
}
