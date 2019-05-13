package racingcar.model;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameTest {

    @Test
    void 자동차_이름_중복_확인() {
        assertThrows(IllegalArgumentException.class, () -> new RacingGame("a,a".split(",")));
    }

    @Test
    void 올바른_CarList_생성_확인() {
        RacingGame carList = new RacingGame("a,b,c,d,e".split(","));
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));
        cars.add(new Car("d"));
        cars.add(new Car("e"));
        assertThat(carList.isEqualCarList(cars)).isTrue();
    }

}
