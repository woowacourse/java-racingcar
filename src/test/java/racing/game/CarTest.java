package racing.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    void 차의위치를출력() {
        Car car = new Car("pobi");
        car.move();
        car.move();
        assertThat(car.showPosition()).isEqualTo("pobi : --");
    }
}
