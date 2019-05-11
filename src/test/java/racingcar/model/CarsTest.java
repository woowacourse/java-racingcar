package racingcar.model;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {

    @Test
    void 자동차_이름_중복_확인() {
        assertThrows(IllegalArgumentException.class, () -> new Cars("a,a".split(",")));
    }

    @Test
    void LinkedHashSet으로_잘_생성되었는지_확인() {
        Cars cars = new Cars("a,b,c,d,e".split(","));
        Set<Car> testCar = new LinkedHashSet<>(Arrays.asList(new Car("a")
                , new Car("b"), new Car("c")
                , new Car("d"), new Car("e")));
        assertThat(cars.isEqualCars(testCar)).isTrue();
    }
}
