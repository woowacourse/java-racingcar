package domain.repository;

import racing.RacingGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Cars;

import static org.assertj.core.api.Assertions.*;

class CarRepositoryTest {

    @DisplayName("자동차 객체가 올바르게 생성되어야 한다.")
    @Test
    void 자동차_객체_생성() {
        String[] carsName = new String[] {"abc"};
        RacingGame racingGame = new RacingGame();
        Cars cars = racingGame.createCars(carsName);

        assertThat(cars.getClass()).isEqualTo(Cars.class);
    }

    @DisplayName("자동차 객체가 생성될 때 자동차 이름이 부여된다.")
    @Test
    void 자동차_객체생성시_이름_확인() {
        String[] carsName = new String[] {"abc", "def"};
        RacingGame racingGame = new RacingGame();

        Cars cars = racingGame.createCars(carsName);
        Assertions.assertEquals(cars.getCar(0).getName(), "abc");
        Assertions.assertEquals(cars.getCar(1).getName(), "def");
    }
}