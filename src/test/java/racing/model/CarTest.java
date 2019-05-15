package racing.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    void 차의_위치를_출력() throws Exception {
        Car car = new Car("pobi");
        car.move(5);
        car.move(5);
        assertThat(car.statusString()).isEqualTo("pobi : --");
    }
}
