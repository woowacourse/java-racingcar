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
    void Set의_순서가_같을_때_True가_나와야_한다() {
        Cars cars = new Cars("a,b,c".split(","));
        Set<Car> testCar = new LinkedHashSet<>(Arrays.asList(new Car("a")
                , new Car("b"), new Car("c")));
        assertThat(cars.isEqualCars(testCar)).isTrue();
    }

    @Test
    void Set의_순서가_다를_때_False가_나와야_한다() {
        Cars cars = new Cars("a,b,c".split(","));
        Set<Car> testCar = new LinkedHashSet<>(Arrays.asList(new Car("c")
                , new Car("b"), new Car("a")));
        assertThat(cars.isEqualCars(testCar)).isFalse();
    }
}
