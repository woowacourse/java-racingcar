package racinggame.race.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.race.car.engine.FixedEngine;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @DisplayName("Cars 객체를 받아 통합하여 String으로 반환하는 메서드 테스트")
    @Test
    void test1() {
        //given
        Car car1 = new Car("a", new FixedEngine());
        Car car2 = new Car("b", new FixedEngine());
        Car car3 = new Car("c", new FixedEngine());

        //when
        Winners winners = new Winners(Arrays.asList(car1, car2, car3));

        //then
        assertThat(winners.getNames()).isEqualTo("a, b, c");
    }
}
