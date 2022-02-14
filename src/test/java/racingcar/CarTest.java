package racingcar;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("Car 생성 테스트 - name")
    @Test
    public void createCar_name(){
        String name = "bunny";
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("Car 생성 테스트 - position")
    @Test
    public void createCar_position(){
        String name = "bunny";
        Car car = new Car(name);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
