package racingcar.DTO;

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
        for(int i=0; i<10 ; i++){
            int num = car.generateRandomNumber();
            System.out.println(num);
            assertThat(num).isLessThan(10);
            assertThat(num).isGreaterThanOrEqualTo(0);
        }
    }
}
