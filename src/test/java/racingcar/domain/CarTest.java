package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Position;
import racingcar.domain.engine.FixedEngine;

class CarTest {

    @Test
    public void 자동차_움직임_및_현재상태_테스트() {
        // given
        Car car = new Car("pobi", new FixedEngine(9));

        // when
        int numOfRacingRound = 5;
        for (int i = 0; i < numOfRacingRound; i++) {
            car.move();
        }

        // then
        assertThat(car.getPosition()).isEqualTo(Position.of(5));
    }

    @Test
    public void 자동차_움직임_및_현재상태_출력_negative() {
        // given
        Car car = new Car("pobi", new FixedEngine(2));

        // when
        int numOfRacingRound = 5;
        for (int i = 0; i < numOfRacingRound; i++) {
            car.move();
        }

        // then
        assertThat(car.getPosition()).isEqualTo(Position.of(0));
    }

}