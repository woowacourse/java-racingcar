package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    Cars cars;
    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    void setUp() {
        cars = Cars.of(Arrays.asList("car1,car2,car3".split(",")));
        Iterator<Car> iterator = cars.toList().iterator();
        car1 = iterator.next();
        car2 = iterator.next();
        car3 = iterator.next();
    }

    @DisplayName("단일 우승자 산출 테스트")
    @Test
    public void singleWinnerTest() {
        car1.setPosition(Integer.MAX_VALUE);
        Winners winners = Winners.of(cars);
        assertThat(winners.toListOfNames().get(0)).isEqualTo(car1.getName());
        assertThat(winners.toListOfNames().contains(car2.getName())).isEqualTo(false);
        assertThat(winners.toListOfNames().contains(car3.getName())).isEqualTo(false);
    }

    @DisplayName("복수 우승자 산출 테스트")
    @Test
    public void multipleWinnerTest() {
        car1.setPosition(Integer.MAX_VALUE);
        car2.setPosition(Integer.MAX_VALUE);
        Winners winners = Winners.of(cars);
        assertThat(winners.toListOfNames().contains(car1.getName())).isEqualTo(true);
        assertThat(winners.toListOfNames().contains(car2.getName())).isEqualTo(true);
        assertThat(winners.toListOfNames().contains(car3.getName())).isEqualTo(false);
    }
}