package racingcargame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    @DisplayName("생성한 난수가 0-9의 범위인지 확인")
    void createRandomNumberRightRange() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(0, 9);
        int result = randomNumberGenerator.pickRandomNumber();

        assertThat(numbers.contains(result)).isTrue();
    }
}