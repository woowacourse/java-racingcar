import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void testToString() {
        Car car = new Car("jena");
        for (int i = 0; i < 5; i++) {
            car.move(4);
        }
        assertThat(car.toString().split(": ")[1].length())
                .isEqualTo(car.getPosition());
    }
}