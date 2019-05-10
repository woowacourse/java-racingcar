package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void randomNumberGeneratorTest(){
        int random = Car.randomNumberGenerator();
        System.out.println(random);
        if(random >= 4){
            System.out.println("is bigger than 4");
            assertThat(random >= 4).isEqualTo(true);
        }if(random < 4){
            System.out.println("is less than 4");
            assertThat(random < 4).isEqualTo(true);
        }
    }

    @Test
    void compareTest() {
        Car testCar = new Car("abc");
        assertThat(testCar.findMax(101)).isEqualTo(101);
    }

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
