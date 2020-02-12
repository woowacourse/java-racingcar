package racingcargame;

import org.junit.jupiter.api.Test;
import racingcargame.view.exception.CarNameException;

import static org.assertj.core.api.Assertions.assertThat;

class CarNameExceptionTest {
    @Test
    void 자동차가_하나일_때() {
        String input = "pobi";
        boolean result = CarNameException.validOneCar(input);
        assertThat(result).isEqualTo(true);
    }
}