package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class RaceStatusTest {
    @Test
    void getWinnersTest() {
        Map<String, Integer> testCars = new LinkedHashMap<String, Integer>() {{
            put("W", 6);
            put("X", 8);
            put("Y", 2);
            put("Z", 8);
        }};
        RaceStatus status = new RaceStatus(testCars, new AlwaysMove());
        status.startEachRound();
        assertThat(status.getNameOfWinners().toString()).isEqualTo(Arrays.asList("X", "Z").toString());
    }
}