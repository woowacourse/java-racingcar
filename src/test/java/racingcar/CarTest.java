package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 자동차_전진_성공() {
        Car car = new Car("jae");
        try (MockedStatic<RandomGenerator> mockRandom = Mockito.mockStatic(RandomGenerator.class)){
            mockRandom.when(() -> RandomGenerator.getRandomNumberInRange(9))
                    .thenReturn(5);
            car.goForward();
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    void 자동차_전진_실패() {
        Car car = new Car("jae");
        try (MockedStatic<RandomGenerator> mockRandom = Mockito.mockStatic(RandomGenerator.class)){
            mockRandom.when(() -> RandomGenerator.getRandomNumberInRange(9))
                    .thenReturn(3);
            car.goForward();
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    @Test
    void 자동차_포지션_출력_성공() {
        Car car = new Car("jae");
        try (MockedStatic<RandomGenerator> mockRandom = Mockito.mockStatic(RandomGenerator.class)){
            mockRandom.when(() -> RandomGenerator.getRandomNumberInRange(9))
                    .thenReturn(5);
            car.goForward();
            assertThat(car.toString()).isEqualTo("jae : -");
        }
    }
}
