package racinggame.race.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.race.car.engine.Engine;
import racinggame.race.car.engine.FixedEngine;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("같은 이름으로 생성한 두 객체가 같은지 테스트")
    @Test
    void test1() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("pobi");

        assertThat(car1).isEqualTo(car2);
    }

    @DisplayName("차를 전진하는 메서드 테스트")
    @Test
    void test2() {
        //given
        Car car = new Car("pobi");
        Engine fixed = new FixedEngine();

        //when
        car.moveWith(fixed);

        //then
        assertThat(car.getDistance()).isEqualTo(2);
    }


}
