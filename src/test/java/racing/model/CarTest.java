package racing.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    void 차의위치를출력() throws Exception {
        Car car = new Car("pobi");
        car.move(5);
        car.move(5);
        assertThat(car.statusString()).isEqualTo("pobi : --");
    }
}
