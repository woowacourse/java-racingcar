package car.domain;

import car.domain.engine.Engine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    
    @Test
    @DisplayName("랜덤값이 주어진 조건보다 크다면 전진")
    void move_RandomValueMoreThanCondition_Move() {
        
        // given
        final Engine engine = new MockEngine(4);
        
        Car car = new Car("tico", engine);
        Car movedCar = new Car("tico", 1, engine);
        
        // when
        car = car.move();
        
        
        // then
        assertThat(car).isEqualTo(movedCar);
    }
    
    @Test
    @DisplayName("랜덤값이 주어진 조건보다 작다면 멈춤")
    void move_RandomValueLessThanCondition_DoNotMove() {
        
        // given
        final Engine engine = new MockEngine(3);
    
        Car car = new Car("tico", engine);
        
        // when
        Car didNotMoveCar = car.move();
        
        // then
        assertThat(car).isEqualTo(didNotMoveCar);
    }
}