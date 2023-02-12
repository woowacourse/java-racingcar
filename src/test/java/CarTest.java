import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @Test
    @DisplayName("move 함수 전진 테스트")
    void move_forward() {
        Car car = new Car("jena");
        car.move(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("move 함수 멈춤 테스트")
    void move_stop() {
        Car car = new Car("jena");
        car.move(3);
        assertThat(car.getDistance()).isEqualTo(0);
    }


}
