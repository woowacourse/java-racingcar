package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class CarTest {
    @BeforeAll
    static void init() {
        mockStatic(RandomGenerator.class);
    }

    @Test
    @DisplayName("랜덤_숫자가_4_이상인_경우_전진")
    void moveCarTest() {
        when(RandomGenerator.getRandomNumberUnderTen()).thenReturn(4);
        Car car = new Car("apple");

        int beforeDistance = car.getDistance();
        car.moveCar(RandomGenerator.getRandomNumberUnderTen());
        int afterDistance = car.getDistance();

        Assertions.assertThat(afterDistance).isEqualTo(beforeDistance + 1);
    }

    @Test
    @DisplayName("랜덤_숫자가_3_이하인_경우_정지")
    void stopCarTest() {
        when(RandomGenerator.getRandomNumberUnderTen()).thenReturn(3);
        Car car = new Car("apple");

        int beforeDistance = car.getDistance();
        car.moveCar(RandomGenerator.getRandomNumberUnderTen());
        int afterDistance = car.getDistance();

        Assertions.assertThat(afterDistance).isEqualTo(beforeDistance);
    }
}