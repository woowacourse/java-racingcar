import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import domain.Car;
import domain.Cars;
import domain.Count;
import domain.RaceResult;
import domain.RandomMovementGenerator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    Car pobi;
    Car kirby;
    Car jonge;

    @BeforeEach
    void setup() {
        pobi = Car.of("포비", 1);
        kirby = Car.of("커비", 10);
        jonge = Car.of("종이", 10);
    }

    @Test
    @DisplayName("차들을 움직이면 거리가 늘어난다.")
    void carsMove() {
        //given
        Cars cars = new Cars(List.of(pobi, kirby, jonge));
        List<Integer> beforeDistances = List.of(1, 10, 10);
        //when
        cars.move(new RandomMovementGenerator((minPower, maxPower) -> 5), new Count(1));
        //then
        for (int i = 0; i < beforeDistances.size(); i++) {
            assertThat(cars.getCars().get(i).getDistance().getValue()).isEqualTo(beforeDistances.get(i) + 1);
        }
    }

    @Test
    @DisplayName("최대 거리인 자동차들를 구한다")
    void getMaxDistance() {
        //given
        Cars cars = new Cars(List.of(pobi, kirby, jonge));
        //when
        RaceResult raceResult = new RaceResult(
                cars.move(new RandomMovementGenerator((minPower, maxPower) -> 5), new Count(1)));
        //then
        assertAll(() -> assertThat(raceResult.getWinners()).contains("커비"),
                () -> assertThat(raceResult.getWinners()).contains("종이"));
    }
}
