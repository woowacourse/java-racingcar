package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    
    @Test
    @DisplayName("랜덤값이 주어진 조건보다 크다면 전진")
    void move_RandomValueMoreThanCondition_Move() {
        
        // given
        Engine engine = new Engine.Fake(4);
        Car car = new Car("tico", 0, engine);
        Car expectedCar = new Car("tico", 1, engine);
    
        // when
        car = car.move();
        
        // then
        assertThat(car).isEqualTo(expectedCar);
    }
    
    @Test
    @DisplayName("랜덤값이 주어진 조건보다 작다면 멈춤")
    void move_RandomValueLessThanCondition_Stop() {
        
        // given
        Engine engine = new Engine.Fake(3);
        Car car = new Car("tico", 0, engine);
        
        // when
        Car expectedCar = car.move();
        
        // then
        assertThat(car).isEqualTo(expectedCar);
    }
    
    @Test
    void carNameTest() {
        assertThatCode(() -> ValidCheck.carNameValid("a,b,c,d124,e"))
                .doesNotThrowAnyException();
        
        assertThatThrownBy(() -> ValidCheck.carNameValid("a,b,c,d1 24,e"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void roundTest() {
        assertThatCode(() -> ValidCheck.round("15")).doesNotThrowAnyException();
        
        assertThatThrownBy(() -> ValidCheck.carNameValid(" "))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> ValidCheck.carNameValid("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}