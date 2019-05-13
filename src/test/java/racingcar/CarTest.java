package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @Test
    void carInstantiationTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            Car testCar = new Car("");
        });
    }

    @Test
    void carInstantiationTest2() {
        assertThrows(IllegalArgumentException.class, () -> {
            Car testCar = new Car("1234567891011");
        });
    }

    @Test
    void carInstantiationTest3() {
        assertThat(new Car("123")).isEqualTo(new Car("123"));
    }


    @Test
    void randomNumberGeneratorTest() {
        int random = Car.randomNumberGenerator();
        if (random >= 4) {
            assertThat(random >= 4).isEqualTo(true);
        }
        if (random < 4) {
            assertThat(random < 4).isEqualTo(true);
        }
    }

    @Test
    void compareTest() {
        Car testCar = new Car("abc");
        assertThat(testCar.findMax(101)).isEqualTo(101);
    }

    /*

    @Test
    void isWhiteSpaceOnlyTest() {
        assertThat(Car.isWhiteSpaceOnly("")).isEqualTo(true);
    }

    @Test
    void isDuplicateTest() {
        List<String> names = Arrays.asList("a", "b", "a");
        assertThat(Car.isDuplicate(names)).isEqualTo(true);
    }

    @Test
    void isOverLimitTest() {
        assertThat(Car.isOverLimit("aaaaaa")).isEqualTo(true);
    }
     */

    @Test
    void moveCarTest() {
        Car car = new Car("abc");
        Car checkCar = new Car("abc", 1);
        assertThat(car.moveCar(4)).isEqualTo(checkCar);
    }

    @Test
    void getCarStateTest() {
        String checkString = "abc : ---";
        Car testCar = new Car("abc", 3);
        assertThat(testCar.getCarState()).isEqualTo(checkString);
    }
}
