package racingcar.domain.movement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberOverThanFourTest {
    @ParameterizedTest
    @DisplayName("랜덤 생성된 숫자가 4 이상이면 전진 값에 대하여 1을 반환하고 4 미만이면 0을 반환한다.")
    @MethodSource("provideDefinedRandomNumberAndExpectedMovementValue")
    void move_Test(NumberGenerator numberGenerator, int expected) {
        //given
        Movement movement = new RandomNumberOverThanFour(numberGenerator);
        //when
        int actual = movement.getMovementValue();
        //then
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideDefinedRandomNumberAndExpectedMovementValue() {
        NumberGenerator threeGenerator = anyBound -> 3;
        NumberGenerator fourGenerator = anyBound -> 4;
        return Stream.of(
                Arguments.of(threeGenerator, 0),
                Arguments.of(fourGenerator, 1)
        );
    }
}