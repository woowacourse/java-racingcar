package car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    
    @Test
    void moveTest() {
        
        // given
        Car car = new Car("tico");
        
        // when
        Car movedCar = car.move();
        
        // then
        assertThat(movedCar).extracting("position")
                            .isEqualTo(1);
    }
}