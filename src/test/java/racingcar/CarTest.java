package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 자동차는_4이상일_경우_전진한다() {
        // given
        Car car = new Car();
        int beforeMove = car.getPosition();
        int number = 4;
        // when
        car.attemptToMove(number);

        // then
        assertThat(beforeMove).isEqualTo(1);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void 같은_위치인_경우_참을_반환한다() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        //when

        //then
        assertThat(car1.isSamePositionWith(car2)).isTrue();
    }

    @Test
    void 같은_위치가_아닌_경우_거짓을_반환한다() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        //when
        car1.attemptToMove(4);
        //then
        assertThat(car1.isSamePositionWith(car2)).isFalse();
    }
}
