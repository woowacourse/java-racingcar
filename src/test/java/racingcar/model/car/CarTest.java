package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.strategy.ForwardMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("자동차의 현재 위치 형식 테스트")
    @Test
    void currentStateFormatTest(){
        // given
        Car car = new Car("pobi", new ForwardMovingStrategy());
        int expected = 1;

        // when
        int actual = car.getPosition();

        // then
        assertThat(actual).isEqualTo(expected);
    };

}
