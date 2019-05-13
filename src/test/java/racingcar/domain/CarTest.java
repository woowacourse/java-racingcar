package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    void create(){
        assertThat(new Car("pobi")).isEqualTo(new Car("pobi"));
    }

    @Test
    void move_메소드_테스트() {
        car.move(5);
        assertThat(car).isEqualTo(new Car("test",1));
    }

    @Test
    void compareTo_테스트() {
        assertThat(car.compareTo(new Car("test",1))).isEqualTo(-1);
    }

    @Test
    void isSamePosition_테스트() {
        assertThat(car.isSamePosition(new Car("test",0))).isTrue();
    }
}
