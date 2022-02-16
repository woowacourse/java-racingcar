package racingcarTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final int INT_OVER_RANDOM_CONDITION = 5;
    private static final int INT_RANDOM_CONDITION = 4;
    private static final int INT_UNDER_RANDOM_CONDITION = 3;
    private static final int CAR_MOVED = 1;
    private static final int CAR_DIDNT_MOVE = 0;

    private static Stream<Arguments> randomConditionArguments() {
        return Stream.of(
            Arguments.of(INT_OVER_RANDOM_CONDITION, CAR_MOVED),
            Arguments.of(INT_RANDOM_CONDITION, CAR_MOVED),
            Arguments.of(INT_UNDER_RANDOM_CONDITION, CAR_DIDNT_MOVE));
    };

    @ParameterizedTest
    @MethodSource("randomConditionArguments")
    @DisplayName("랜덤값에_따라_전진_실행")
    void randomNum_is4OrOver_carGoForward(int random, int expectedCarPosition) {
        Car testCar = new Car("test");

        testCar.goForward(random);
        assertThat(testCar.getPosition()).isEqualTo(expectedCarPosition);
    }
}
