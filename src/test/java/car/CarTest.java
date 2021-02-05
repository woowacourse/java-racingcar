package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    
    private java.util.Scanner Scanner;
    
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
    
    @Test
    void carNameTest() {
        assertThat(ValidCheck.carNameValid("a,b,c,d124,e")).isTrue();
        assertThat(ValidCheck.carNameValid("a,b,c,d1 24,e")).isFalse();
    }
}