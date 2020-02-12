package racingcargame;

import org.junit.jupiter.api.Test;
import racingcargame.view.exception.CarNameException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 자동차_이름의_길이가_5를_초과할때() {
        String[] input = {"abcde", "123456789"};

        CarNameException.CAR_NAMES.addAll(Arrays.asList(input));

        assertThatThrownBy(() -> CarNameException.haveExceededLengthName())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 쉼표만_입력되었을_때() {
        String[] input = {"", ""};

        CarNameException.CAR_NAMES.addAll(Arrays.asList(input));

        assertThatThrownBy(CarNameException::checkBlankInput)
                .isInstanceOf(RuntimeException.class);
    }
}