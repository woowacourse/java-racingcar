package application.racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceResultParticipantTest {

    private RaceParticipants raceParticipants;
    private List<Car> cars;
    private Car pobi;
    private Car lavin;
    private Car ramen;

    @BeforeEach
    void setUp() {
        List<String> carNames = Arrays.asList("pobi","lavin","ramen");
        cars = new ArrayList<>();
        raceParticipants = new RaceParticipants(carNames);
        pobi = new Car("pobi");
        lavin = new Car("lavin");
        ramen = new Car("ramen");
        cars.add(pobi);
        cars.add(lavin);
        cars.add(ramen);
    }

    @Test
    void raceParticipants_getCars의_반환값이_cars와_일치한다() {
        for(int carIndex=0; carIndex<cars.size(); carIndex++) {
            assertThat(raceParticipants.getCars().get(carIndex).getName()).isEqualTo(cars.get(carIndex).getName());
        }

    }
}
