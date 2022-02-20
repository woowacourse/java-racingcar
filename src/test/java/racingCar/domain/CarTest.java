package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingCar.domain.moveStrategy.MovableNumGenerator;
import racingCar.domain.moveStrategy.NonMovableNumGenerator;
import racingCar.domain.moveStrategy.NumGenerator;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {
    private final Car car = new Car("jiwoo", 0);

    @Test
    void move_3넣으면_이동안함() {
        //given
        NumGenerator numGenerator = new NonMovableNumGenerator();

        //when
        car.move(numGenerator);

        //then
        assertThat(car).extracting("position").isEqualTo(0);
    }

    @Test
    void move_4넣으면_이동() {
        //given
        NumGenerator numberGenerator = new MovableNumGenerator();

        //when
        car.move(numberGenerator);

        //then
        assertThat(car).extracting("position").isEqualTo(1);
    }
}