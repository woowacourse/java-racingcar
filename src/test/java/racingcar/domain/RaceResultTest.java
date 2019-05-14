package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class RaceResultTest {
    @Test
    void getWinnersTest() {
        Map<String, Integer> testCars = new LinkedHashMap<String, Integer>() {{
            put("W", 6);
            put("X", 8);
            put("Y", 2);
            put("Z", 8);
        }};
        Race race = new Race(testCars, 2);
        race.next();
        assertThat(race.finish().getWinners().keySet().toString()).isEqualTo(Arrays.asList("X", "Z").toString());
    }
}