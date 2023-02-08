package car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @Test
    void 이름을_가진다() {
        Car car = new Car("물떡");

        assertThat(car.getName()).isEqualTo("물떡");
    }

    @Test
    void 위치를_가진다() {
        Car car = new Car("물떡", 2);

        assertThat(car.getPosition()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void 움직일_수_있으면_전진하고_아니면_정지한다(boolean provided, int result) {
        Car car = new Car("물떡");
        car.move(() -> provided);
        assertThat(car.getPosition()).isEqualTo(result);
    }
}
