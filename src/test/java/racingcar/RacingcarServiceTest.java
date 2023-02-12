package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingcarService;

class RacingcarServiceTest {

    @Test
    @DisplayName("우승자 확인하기")
    void findWinner() {
        RacingcarService racingcarService = new RacingcarService(Arrays.asList("car1", "car2", "car3"));

        List<String> winnersCarText = racingcarService.findWinners();

        assertThat(winnersCarText).containsExactly("car1,0", "car2,0", "car3,0");
    }

    @Test
    @DisplayName("경주 참여 인원 두명 미만인 경우 예외")
    void validateParticipants() {
        assertThatThrownBy(() -> new RacingcarService(Arrays.asList("car1")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 경주는 최소 2명이 필요해요.");
    }
}
