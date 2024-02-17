package racingcar.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.OilOutOfRangeException;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.domain.generator.OilGenerator.MAX_OIL_AMOUNT;
import static racingcar.domain.generator.OilGenerator.MIN_OIL_AMOUNT;

class OilGeneratorTest {

    @DisplayName("유효하지 값이 생성되면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(ints = {10, 11, -1, 100})
    void testGenerateInvalidOil(int oil) {
        OilGenerator generator = new TestOilGenerator(oil);
        assertThatThrownBy(generator::generateValidOil)
                .isInstanceOf(OilOutOfRangeException.class);
    }

    @DisplayName("유효한 값이 생성되면 예외를 던지지 않는다")
    @ParameterizedTest
    @MethodSource("generateValidOilValues")
    void testGenerateValidOil(int oil) {
        OilGenerator generator = new TestOilGenerator(oil);
        assertThatCode(generator::generateValidOil)
                .doesNotThrowAnyException();
    }

    static Stream<Integer> generateValidOilValues() {
        return IntStream.rangeClosed(MIN_OIL_AMOUNT, MAX_OIL_AMOUNT)
                .boxed();
    }

    static class TestOilGenerator extends OilGenerator {

        private final int fixedOil;

        public TestOilGenerator(int fixedOil) {
            this.fixedOil = fixedOil;
        }

        @Override
        protected int generate() {
            return fixedOil;
        }
    }
}
