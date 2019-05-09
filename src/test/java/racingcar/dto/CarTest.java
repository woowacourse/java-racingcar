package racingcar.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    void 난수생성테스트() {
        for (int i = 0; i < 10; i++) {
            int num = car.generateRandomNumber();
            System.out.println(num);
            assertThat(num).isLessThan(10);
            assertThat(num).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    void 자동차가움직이는조건테스트() {
        for (int i = 0; i < 10; i++) {
            int num = car.generateRandomNumber();
            System.out.println(num + " " + car.isPossibleMove(num));
            /*assertThat(num > 4).isTrue();
            assertThat(num <= 4).isFalse();*/
            //assertThat(car.isPossibleMove(num)).isTrue();
        }
    }

    @Test
    void 숫자가4이하일때움직이지않는지테스트() {
        int before = car.getPosition();
        car.move(4);
        int after = car.getPosition();

        assertThat(after).isEqualTo(before);
    }

    @Test
    void 숫자가5이상일때움직이는지테스트() {
        int before = car.getPosition();
        car.move(5);
        int after = car.getPosition();

        assertThat(after).isEqualTo(before+1);
    }
}
