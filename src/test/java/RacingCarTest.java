import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RacingCarTest {
    @Test
    void 자동차에_이름을_부여() {
        RacingCar racingCar = new RacingCar("name");
        assertNotNull(racingCar);
    }
}
