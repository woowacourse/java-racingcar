package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingcarService;
import racingcar.util.TextSplit;

class RacingcarServiceTest {

    @Test
    @DisplayName("우승자 확인하기")
    void findWinner() {
        RacingcarService racingcarService = new RacingcarService(Arrays.asList("car1", "car2", "car3"));

        List<String> winnersCarText = racingcarService.findWinners();

        List<String> winners = winnersCarText.stream()
                .map(text -> TextSplit.split(text, ",").get(0))
                .collect(Collectors.toList());

        assertThat(winners).containsExactly("car1", "car2", "car3");
    }
}
