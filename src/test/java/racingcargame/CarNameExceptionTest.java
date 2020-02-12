package racingcargame;

import org.junit.jupiter.api.Test;
import racingcargame.view.exception.CarNameException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarNameExceptionTest {
    @Test
    void 자동차가_하나일_때() {
        String input = "pobi";
        boolean result = CarNameException.validOneCar(input);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 자동차_이름이_중복되었을_때() {
        String[] input = {"pobi", "pobi"};

        CarNameException.CAR_NAMES.addAll(Arrays.asList(input));

        boolean  result = CarNameException.isDuplicatedNames(input);
        assertThat(result).isEqualTo(true);
    }
}