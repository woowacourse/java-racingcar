package car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 이름을_가진다() {
        Car car = new Car("물떡");

        assertThat(car.getName()).isEqualTo("물떡");
    }
}
