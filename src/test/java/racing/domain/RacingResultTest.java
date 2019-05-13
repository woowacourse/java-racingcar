package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {
    @Test
    void 이동맥스확인() {
        List<Car> cars = Arrays.asList(new Car("pobi", 5), new Car("buddy", 5),
                new Car("luffy", 3), new Car("jason", 2));
        RacingResult result = new RacingResult(cars);
        assertThat(result.getMaxPosition()).isEqualTo(5);
    }

}