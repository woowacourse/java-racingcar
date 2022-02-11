package racingcargame.utils;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @Test
    void 난수_생성_범위_테스트() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int actual = RandomNumberGenerator.makeRandomNumber();

        assertThat(numbers.contains(actual)).isTrue();
    }
}