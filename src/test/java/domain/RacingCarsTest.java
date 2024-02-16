package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RacingCarsTest {

    @Test
    @DisplayName("랜덤값이 4이상인 레이상카들을 한칸씩 전진시킨다.")
    void tryRace() {
        RacingCars racingCars = new RacingCars(List.of(new RacingCar("zeze"), new RacingCar("bito")));

        List<RaceResult> raceResults = racingCars.tryRace(() -> 4);

        raceResults.forEach(raceResult -> Assertions.assertThat(raceResult.moveCount()).isEqualTo(1));
    }

    @Test
    @DisplayName("우승자를 1명 반환한다.")
    void getWinner() {
        RacingCar winnerCar = new RacingCar("zeze");
        RacingCar car = new RacingCar("bito");

        winnerCar.race(4);
        car.race(3);

        RacingCars racingCars = new RacingCars(new ArrayList(List.of(winnerCar, car)));

        Assertions.assertThat(racingCars.getWinners()).containsOnly(winnerCar.getName());
    }

    @Test
    @DisplayName("우승자를 2명 반환한다.")
    void getWinners() {
        RacingCar winnerCar1 = new RacingCar("zeze");
        RacingCar winnerCar2 = new RacingCar("bito");

        winnerCar1.race(4);
        winnerCar2.race(4);

        RacingCars racingCars = new RacingCars(new ArrayList(List.of(winnerCar1, winnerCar2)));

        Assertions.assertThat(racingCars.getWinners()).containsAll(List.of(winnerCar1.getName(), winnerCar2.getName()));
    }
}
