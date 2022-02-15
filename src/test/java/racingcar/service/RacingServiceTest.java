package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class RacingServiceTest {
    private static final int PROCEED_FlAG_NUMBER = 4;

    private List<Car> cars;
    private Car carA;
    private Car carB;
    private Car carC;
    private Car carD;
    private RacingService racingService;

    @BeforeEach
    void beforeEach() {
        carA = new Car("A");
        carB = new Car("B");
        carC = new Car("C");
        carD = new Car("D");

        cars = new ArrayList<>();
        cars.add(carA);
        cars.add(carB);
        cars.add(carC);
        cars.add(carD);

        racingService = new RacingService(cars);
    }

    @Test
    void 우승자_판단() {
        carA.proceed(PROCEED_FlAG_NUMBER);
        assertThat(racingService.findWinners()).contains(carA);
    }

    @Test
    void 중복_우승자_판단() {
        carA.proceed(PROCEED_FlAG_NUMBER);
        carB.proceed(PROCEED_FlAG_NUMBER);
        assertThat(racingService.findWinners()).contains(carA, carB);
    }
}
