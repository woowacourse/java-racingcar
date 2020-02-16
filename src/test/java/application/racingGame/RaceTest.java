package application.racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RaceTest {
    private RaceParticipants raceParticipants;
    private RacingLabConsoleInput racingLabConsoleInput = mock(RacingLabConsoleInput.class);
    private RacingCarConsoleInput racingCarConsoleInput = mock(RacingCarConsoleInput.class);
    private List<Car> cars;
    private Race race;
    private Car pobi;
    private Car lavin;
    private Car ramen;

    @BeforeEach
    void setUp() {
        raceParticipants = new RaceParticipants(racingCarConsoleInput);
        cars = new ArrayList<>();
        race = new Race();
        pobi = new Car("pobi");
        lavin = new Car("lavin");
        ramen = new Car("ramen");
        cars.add(pobi);
        cars.add(lavin);
        cars.add(ramen);
    }

    @Test
    void run_메서드가_올바르게_작동한다() {
        List<String> winners = Arrays.asList("pobi");
        when(racingCarConsoleInput.getCarNames()).thenReturn("pobi");
        when(racingLabConsoleInput.getRacingLabValue()).thenReturn("2");
        assertThat(race.run(raceParticipants, racingLabConsoleInput)).isEqualTo(winners);
    }

}
