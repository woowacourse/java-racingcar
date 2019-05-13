package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    void carInitializerTest() {
        assertThat(new Car("pobi")).isEqualTo(new Car("pobi"));
    }

    @Test
    void maxNameLengthTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("123456");
        });
    }

    @Test
    void minNameLengthTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

    @Test
    void goForwardFailTest() {
        Car car =new Car("pobi");
        car.tryGoForward(3);
        assertThat(car).isEqualTo(new Car("pobi",0));
    }

    @Test
    void goForwardSuccessTest() {
        Car car =new Car("pobi");
        car.tryGoForward(4);
        assertThat(car).isEqualTo(new Car("pobi",1));
    }

    @Test
    void carCompareTest() {
        Car fastCar = new Car("pobi", 1);
        Car slowCar = new Car("crong", 0);
        assertThat(fastCar.compareTo(slowCar) == 1).isTrue();
        assertThat(slowCar.compareTo(fastCar) == -1).isTrue();
        assertThat(fastCar.compareTo(new Car("honux", 1)) == 0).isTrue();
    }
}
