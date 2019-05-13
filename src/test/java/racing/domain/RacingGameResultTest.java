package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameResultTest {

    @Test
    void 우승자확인() {
        List<Car> cars = Arrays.asList(new Car("pobi", 5), new Car("buddy", 5),
                new Car("luffy", 3), new Car("jason", 2));
        RacingGameResult result = new RacingGameResult();
        result.addResult(new RacingResult(cars));

        assertThat(result.searchWinners()).isEqualTo("pobi,buddy");
    }

}