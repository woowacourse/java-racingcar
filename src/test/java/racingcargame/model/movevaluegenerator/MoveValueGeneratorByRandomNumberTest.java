package racingcargame.model.movevaluegenerator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.model.movevaluegenerator.randomnumbergenerator.NumberGenerator;

class MoveValueGeneratorByRandomNumberTest {

    class RandomNumberGeneratorTest implements NumberGenerator {

        @Override
        public int generateNumber(int boundaryNumber) {
            return 5;
        }
    }

    @DisplayName("난수 값이 4보다 크면 1을 반환한다.")
    @Test
    void getMoveValue_high() {
        final NumberGenerator numberGenerator = new RandomNumberGeneratorTest();
        final MoveValueGenerator moveValueGenerator = new MoveValueGeneratorByRandomNumber(numberGenerator);

        assertThat(moveValueGenerator.generateMoveValue()).isEqualTo(1);
    }
}