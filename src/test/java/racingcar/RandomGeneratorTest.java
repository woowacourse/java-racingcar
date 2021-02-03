package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomGeneratorTest {

    @DisplayName("0 ~ 9 사이 생성")
    @Test
    void generateRandomNumber() {
        List<Integer> result = new ArrayList<>();

        Assertions.assertThat(generateNumber(result, 10).stream()
                .allMatch(number -> number >= 0 && number < 10)).isTrue();
    }

    public List<Integer> generateNumber(List<Integer> values, int leftTime) {
        if (leftTime == 0 || leftTime > 10) {
            return values;
        }

        int randomValue = RandomGenerator.generateRandomNumber(0, 9);

        if (values.contains(randomValue)) {
            return generateNumber(values, leftTime);
        }

        values.add(randomValue);
        return generateNumber(values, --leftTime);
    }
}
