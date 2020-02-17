package application.racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RaceResultTest {
    private RaceParticipants raceParticipants = mock(RaceParticipants.class);
    private List<Car> cars;
    private RaceResult raceResult;
    private Car pobi;
    private Car lavin;
    private Car ramen;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        raceResult = new RaceResult();
        pobi = new Car("pobi");
        lavin = new Car("lavin");
        ramen = new Car("ramen");
        cars.add(pobi);
        cars.add(lavin);
        cars.add(ramen);
    }

    @Test
    void run_메서드가_올바르게_작동한다() {
        List<String> winners = Arrays.asList("pobi","lavin","ramen");
        when(raceParticipants.getCars()).thenReturn(cars);
        assertThat(raceResult.run(raceParticipants, 0)).isEqualTo(winners);
    }

}
