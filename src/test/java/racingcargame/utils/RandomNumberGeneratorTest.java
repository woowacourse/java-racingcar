package racingcargame.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @DisplayName("생성된 난수가 올바른 범위인지 테스트")
    @Test
    void pickRandomNumber_Range() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(numbers.contains(RandomNumberGenerator.pickRandomNumber())).isTrue();
    }
}