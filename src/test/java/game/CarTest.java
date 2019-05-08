package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차_이름_확인() {
        Car car = new Car("bongjin");
        String result = car.getCarName();
        assertThat(result).isEqualTo("bongjin");
    }
}
