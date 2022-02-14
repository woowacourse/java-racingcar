package racingcargame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("난수 생성에 쓰일 숫자 리스트 생성 확인")
    void createNumbersForRandom(int number) {
        List<Integer> numbers = RandomNumbers.of(0, 10).getNumbers();

        assertThat(numbers.contains(number)).isTrue();
    }
}