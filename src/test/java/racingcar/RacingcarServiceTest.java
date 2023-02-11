package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

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
}
