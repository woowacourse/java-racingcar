package racingcargame.domain.result;

import org.junit.jupiter.api.Test;
import racingcargame.domain.car.Car;
import racingcargame.domain.result.CarRaceResult;
import racingcargame.domain.result.CarSnapShot;
import racingcargame.domain.result.RoundResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceResultTest {

    @Test
    void carRaceResult() {
        List<Car> cars = new ArrayList<>();
        Car carJ = new Car("제이");
        Car carPobi = new Car("포비");
        Car carLatter = new Car("라테");

        cars.add(carJ);
        cars.add(carPobi);
        cars.add(carLatter);

        List<CarSnapShot> round1SnapShots = cars.stream().map(CarSnapShot::new).collect(Collectors.toList());
        RoundResult round1 = new RoundResult(round1SnapShots);

        cars.get(0).move(4);
        cars.get(0).move(4);
        cars.get(0).move(4);

        cars.get(2).move(4);
        cars.get(2).move(4);
        cars.get(2).move(4);

        List<CarSnapShot> round2SnapShots = cars.stream().map(CarSnapShot::new).collect(Collectors.toList());
        RoundResult round2 = new RoundResult(round2SnapShots);

        List<RoundResult> roundResults = new ArrayList<>();
        roundResults.add(round1);
        roundResults.add(round2);

        CarRaceResult carRaceResult = new CarRaceResult(roundResults);

        assertThat(carRaceResult.getWinners()).contains("제이").contains("라테");
        assertThat(carRaceResult.getRoundResultList()).size().isEqualTo(2);
    }
}