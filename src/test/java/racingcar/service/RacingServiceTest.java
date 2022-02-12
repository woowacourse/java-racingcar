package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class RacingServiceTest {
    private static final int PROCEED_FlAG_NUMBER = 4;

    //todo: BeforeEach, AfterEach 활용해서 테스트 준비과정 줄이기

    @Test
    @DisplayName("우승자 판단 - 단독")
    void checkSingleWinner() {
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");
        Car carD = new Car("D");

        carA.proceed(PROCEED_FlAG_NUMBER);

        List<Car> cars = new ArrayList<Car>();
        cars.add(carA);
        cars.add(carB);
        cars.add(carC);
        cars.add(carD);

        RacingService racingService = new RacingService(cars);
        assertThat(racingService.findWinners()).contains(carA);
    }

    @Test
    @DisplayName("우승자 판단 - 공동 우승")
    void checkCoWinner() {
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");
        Car carD = new Car("D");

        carA.proceed(PROCEED_FlAG_NUMBER);
        carB.proceed(PROCEED_FlAG_NUMBER);

        List<Car> cars = new ArrayList<Car>();
        cars.add(carA);
        cars.add(carB);
        cars.add(carC);
        cars.add(carD);

        RacingService racingService = new RacingService(cars);
        assertThat(racingService.findWinners()).contains(carA, carB);
    }
}
