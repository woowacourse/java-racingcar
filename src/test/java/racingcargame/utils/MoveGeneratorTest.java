package racingcargame.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveGeneratorTest {

    class RandomNumberGeneratorTest implements NumberGenerator {

        @Override
        public int generateNumber(int boundaryNumber) {
            return 5;
        }
    }

    @DisplayName("생성된 난수 값이 4보다 큰 경우 1을 반환하는지 테스트")
    @Test
    void getMoveValue_high() {
        NumberGenerator numberGenerator = new RandomNumberGeneratorTest();
        Move move = new MoveGenerator(numberGenerator);

        assertThat(move.getMoveValue()).isEqualTo(1);
    }
}