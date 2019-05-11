package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceResultTest {
    @Test
    void 레이스_결과_생성() {
        RaceResult raceResult = new RaceResult();
        RaceResult anotherRaceResult = new RaceResult();

        raceResult.add(new Car("pobi"));
        anotherRaceResult.add(new Car("pobi"));
        raceResult.add(new Car("cu"));
        anotherRaceResult.add(new Car("cu"));
        assertThat(raceResult).isEqualTo(anotherRaceResult);
    }

    @Test
    void 우승자_한명() {
        RaceResult raceResult = new RaceResult();
        raceResult.add(new Car("pobi", 5));
        raceResult.add(new Car("brown", 4));
        raceResult.add(new Car("jun", 3));
        raceResult.add(new Car("jason", 2));
        assertThat(raceResult.findWinningCars().get(0)).isEqualTo(new Car("pobi", 5));
    }

    @Test
    void 우승자_두명() {
        RaceResult raceResult = new RaceResult();
        raceResult.add(new Car("pobi", 5));
        raceResult.add(new Car("brown", 5));
        raceResult.add(new Car("jun", 3));
        raceResult.add(new Car("jason", 2));
        List<Car> winningCars = raceResult.findWinningCars();

        assertThat(winningCars.size()).isEqualTo(2);
        assertThat(winningCars.get(0)).isEqualTo(new Car("pobi", 5));
        assertThat(winningCars.get(1)).isEqualTo(new Car("brown", 5));
    }

}
