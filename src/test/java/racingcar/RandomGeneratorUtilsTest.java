package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomGeneratorUtilsTest {

    @DisplayName("0이상, 9이하의 랜덤정수 생성 테스트")
    @Test
    void generateRandomNumberZeroOrMoreAndNineOrLess() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 10) {
            int randomNumber = RandomGeneratorUtils.generateRandomNumber(0, 9);
            addRandomNumberIfNotContains(randomNumbers, randomNumber);
        }
        assertThat(randomNumbers.stream().allMatch(number -> 0 <= number && number <= 9)).isTrue();
    }

    private void addRandomNumberIfNotContains(List<Integer> randomNumbers, int randomNumber) {
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }
}
