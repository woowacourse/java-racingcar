package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class RaceTest {
    @Test
    void getWinnersTest() {
        Map<String, Integer> testCars = new LinkedHashMap<String, Integer>() {{
            put("W", 6);
            put("X", 8);
            put("Y", 2);
            put("Z", 8);
        }};
        Race race = new Race(testCars, new AlwaysMove());
        race.startEachRound();
        assertThat(race.getWinners().toString()).isEqualTo(Arrays.asList("X", "Z").toString());
    }
}