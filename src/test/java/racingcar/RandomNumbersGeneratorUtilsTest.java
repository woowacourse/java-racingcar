package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumbersGeneratorUtilsTest {

    @DisplayName("매개변수로 넘긴 개수만큼 랜덤 정수를 반환하는가?")
    @Test
    void generateRandomNumbers() {
        int numberOfRandomNumbersToGenerate = 6;
        List<Integer> randomNumbers = RandomNumbersGeneratorUtils
            .generateRandomNumbersSizeOf(numberOfRandomNumbersToGenerate);
        assertThat(randomNumbers.size()).isEqualTo(numberOfRandomNumbersToGenerate);
    }
}
