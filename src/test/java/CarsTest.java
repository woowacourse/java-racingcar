import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    @DisplayName("차들 객체를 생성한다.")
    void cars() {
        assertThatCode(Cars::fromEmpty).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("차들을 움직이면 거리가 늘어난다.")
    void carsMove() {
        Cars cars = Cars.fromEmpty();
        cars.move(new RandomMovementGenerator(new RandomNumberGenerator()));
    }

}
