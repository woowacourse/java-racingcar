package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    
    @Test
    @DisplayName("랜덤값이 주어진 조건보다 크다면 전진")
    void move_RandomValueMoreThanCondition_ShouldMove() {
        
        // given
        Car car = new Car("tico");
        Car expectedCar = new Car("tico", 1);
        
        // when
        car.move();
    
        // then
        assertThat(car).isEqualTo(expectedCar);
    }
}