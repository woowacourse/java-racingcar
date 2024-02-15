package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {

    static Stream<Arguments> moves() {

        return Stream.of(
                Arguments.of(true, 1, "true면 전진한다."),
                Arguments.of(false, 0, "false면 전진한다.")
        );
    }

    @ParameterizedTest(name = "{2}")
    @DisplayName("true면 전진한다.")
    @MethodSource("moves")
    void move(boolean doMove, int expected, String title) {
        Car car = new Car("배키");
        car.move(doMove);
        int result = car.getMovement();

        assertThat(result).isEqualTo(expected);
    }

}