package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    
    @Test
    @DisplayName("랜덤값이 주어진 조건보다 크다면 전진")
    void move_RandomValueMoreThanCondition_Move() {
        
        // given
        Car car = new Car.Builder("tico").withFakeEngine(4)
                                         .build();
        
        Car movedCar = new Car.Builder("tico").withPosition(1)
                                              .withFakeEngine(4)
                                              .build();
        
        // when
        car = car.move();
        
        
        // then
        assertThat(car).isEqualTo(movedCar);
    }
    
    @Test
    @DisplayName("랜덤값이 주어진 조건보다 작다면 멈춤")
    void move_RandomValueLessThanCondition_DoNotMove() {
        
        // given
        Car car = new Car.Builder("tico").withFakeEngine(3)
                                         .build();
        
        // when
        Car didNotMoveCar = car.move();
        
        // then
        assertThat(car).isEqualTo(didNotMoveCar);
    }
    
    @Test
    void carNameTest() {
        assertThatCode(() -> ValidCheck.carNameValid("a,b,c,d124,e")).doesNotThrowAnyException();
        
        assertThatThrownBy(() -> ValidCheck.carNameValid("a,b,c,d1 24,e")).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void roundTest() {
        assertThatCode(() -> ValidCheck.round("15")).doesNotThrowAnyException();
        
        assertThatThrownBy(() -> ValidCheck.carNameValid(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ValidCheck.carNameValid("0")).isInstanceOf(IllegalArgumentException.class);
    }
}