package racingcarTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Model.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @ParameterizedTest
    @CsvSource(value = {"3, false", "4, true"})
    void isMovable_숫자가_4_이하이면_움직일수_있다(int randomNo, boolean result) {
        RandomNumber randomNumber = new RandomNumber();
        assertThat(randomNumber.isMovable(randomNo)).isEqualTo(result);
    }
}
