package racingcar.domain;

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
    void create(){
        assertThat(new Car("pobi")).isEqualTo(new Car("pobi"));
    }

    /*@Test
    void 난수생성테스트() {
        for (int i = 0; i < 10; i++) {
            int num = car.generateRandomNumber();
            System.out.println(num);
            assertThat(num).isLessThan(10);
            assertThat(num).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    void 자동차가_움직이는조건_테스트() {
        for (int i = 0; i < 10; i++) {
            int num = car.generateRandomNumber();
            System.out.println(num + " " + car.isPossibleMove(num));
        }
    }*/

    @Test
    void 숫자가_4이하일때_움직이지않는지_테스트() {
        int before = car.getPosition();
        car.move(4);
        int after = car.getPosition();
        assertThat(after).isEqualTo(before);
    }

    @Test
    void 숫자가_5이상일때_움직이는지_테스트() {
        int before = car.getPosition();
        car.move(5);
        int after = car.getPosition();

        assertThat(after).isEqualTo(before+1);
    }
}
