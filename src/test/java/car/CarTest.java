package car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @CsvSource(value = {"0:0","3:0","4:1","9:1"}, delimiter = ':')
    void 랜덤값이_0이상_3이하일때_정지하고_4이상_9이하일때_전진한다(int provided, int position){
        Car car = new Car("물떡");
        car.move(provided);
        assertThat(car.getPosition()).isEqualTo(position);
    }

}
