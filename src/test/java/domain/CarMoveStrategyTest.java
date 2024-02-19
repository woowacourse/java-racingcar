package domain;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarMoveStrategyTest {

    @DisplayName("임의의 숫자가 3 이하인 경우에는 이동하지 않고, 4 이상인 경우에는 이동한다")
    @ParameterizedTest
    @MethodSource("moveRandomlyTestProvider")
    void moveRandomlyTest(IntSupplier supplier, boolean expected) {
        CarMoveStrategy moveStrategy = new CarMoveStrategy(supplier);

        // when
        boolean actual = moveStrategy.isMove();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> moveRandomlyTestProvider() {
        return Stream.of(
                Arguments.of(new CarMovableSupplier(), true),
                Arguments.of(new CarNotMovableSupplier(), false)
        );
    }

    static class CarNotMovableSupplier implements IntSupplier {

        private static final Random random = new Random();

        @Override
        public int getAsInt() {
            return random.nextInt(4);
        }
    }

    static class CarMovableSupplier implements IntSupplier {

        private static final Random random = new Random();

        @Override
        public int getAsInt() {
            int randomInt = random.nextInt(10);
            if (randomInt < 4) {
                return getAsInt();
            }
            return randomInt;
        }
    }
}
