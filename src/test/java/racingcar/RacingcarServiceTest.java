package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.RacingcarService;

class RacingcarServiceTest {

    @Test
    @DisplayName("우승자 확인하기")
    void findWinner() {
        RacingcarService racingcarService = new RacingcarService("car1,car2,car3");

        List<Car> winners = racingcarService.findWinners();

        assertThat(winners.toString()).contains("car1", "car2", "car3");
    }
}
