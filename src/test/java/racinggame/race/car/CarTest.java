package racinggame.race.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.race.car.engine.Engine;
import racinggame.race.car.engine.FixedEngine;

import java.util.Arrays;

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
        Car car = new Car("pobi");
        Engine fixed = new FixedEngine();
        car.moveWith(fixed);

        assertThat(car.getDistance()).isEqualTo(2);
    }

    @DisplayName("가장 멀리간 차의 거리를 반환하는 메서드 테스트")
    @Test
    void test3() {
        //given
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");
        //when
        car1.moveWith(new FixedEngine());
        car2.moveWith(new FixedEngine());

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));
        //then
        assertThat(cars.getWinner()).isEqualTo(new Winners(Arrays.asList(car1, car2)));
    }
}
