import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void testToString() {
        Car car = new Car("jena");
        for (int i = 0; i < 5; i++) {
            car.move();
        }
        assertThat(car.toString().split(": ")[1].length())
                .isEqualTo(car.getDistance());
    }
}
