package racingcar.domain.racingcargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarPosition;
import racingcar.domain.car.Cars;
import racingcar.domain.car.util.RandomNumberGenerator;
import racingcar.domain.trynumber.TryNumber;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarGameTest {

    @DisplayName("주어진 횟수만큼 자동차 경주를 실행하는 기능을 테스트한다.")
    @Test
    void testExecute() {
        //given
        Cars cars = new Cars(Arrays.asList(new Car("benz"), new Car("test")));
        TryNumber tryNumber = new TryNumber(2);

        //when
        RacingCarGame racingCarGame = new RacingCarGame(cars, tryNumber);
        List<Cars> runResult = racingCarGame.execute(new RandomNumberGenerator());

        //then
        Cars firstRunResult = runResult.get(0);
        List<Car> firstRunResultCars = firstRunResult.getCars();
        Cars secondRunResult = runResult.get(1);
        List<Car> secondRunResultCars = secondRunResult.getCars();
        assertAll(
                () -> assertThat(firstRunResultCars.get(0).getPosition()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(2),
                () -> assertThat(firstRunResultCars.get(1).getPosition()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(2),
                () -> assertThat(secondRunResultCars.get(0).getPosition()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(2),
                () -> assertThat(secondRunResultCars.get(1).getPosition()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(2)
        );
    }

    @DisplayName("우승자를 찾는 기능을 테스트한다")
    @Test
    void testFindWinners() {
        //given
        Cars playedCars = new Cars(Arrays.asList(new Car("benz", new CarPosition(3)),
                new Car("kia", new CarPosition(1)), new Car("bmw", new CarPosition(0))));
        TryNumber tryNumber = new TryNumber(1);

        //when
        RacingCarGame racingCarGame = new RacingCarGame(playedCars, tryNumber);
        List<Car> cars = racingCarGame.findWinners();

        //then
        assertThat(cars).hasSize(1);
        assertThat(cars.get(0)).isEqualTo(new Car("benz", new CarPosition(3)));
    }
}