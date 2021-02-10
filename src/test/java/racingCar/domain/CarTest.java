package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingCar.domain.Engine.FixedEngine;

class CarTest {

    @Test
    public void 자동차_움직임_및_현재상태출력_테스트() {
        // given
        Car car = new Car("pobi", new FixedEngine(9));

        // when
        int numOfRacingRound = 5;
        for (int i = 0; i < numOfRacingRound; i++) {
            car.run();
        }

        // then
        assertThat(car.toString()).isEqualTo("pobi : -----");
    }

    @Test
    public void 자동차_움직임_및_현재상태_출력_negative() {
        // given
        Car car = new Car("pobi", new FixedEngine(2));

        // when
        int numOfRacingRound = 5;
        for (int i = 0; i < numOfRacingRound; i++) {
            car.run();
        }

        // then
        assertThat(car.toString()).isEqualTo("pobi : ");
    }

}