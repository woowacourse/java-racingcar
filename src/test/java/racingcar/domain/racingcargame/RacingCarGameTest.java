package racingcar.domain.racingcargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.util.RandomNumberGenerator;
import racingcar.domain.trynumber.TryNumber;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @DisplayName("주어진 횟수만큼 자동차 경주를 실행하는 기능을 테스트한다.")
    @Test
    void testExecute() {
        //given
        Cars cars = new Cars(Arrays.asList(new Car("benz"), new Car("test"), new Car("kia")));
        TryNumber tryNumber = new TryNumber(4);

        //when
        RacingCarGame racingCarGame = new RacingCarGame(cars, tryNumber);
        racingCarGame.execute(new RandomNumberGenerator());

        //then
        List<Car> resultCars = racingCarGame.getCars().getCars();
        assertThat(resultCars.get(0).getPosition()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(4);
        assertThat(resultCars.get(1).getPosition()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(4);
        assertThat(resultCars.get(2).getPosition()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(4);
    }
}