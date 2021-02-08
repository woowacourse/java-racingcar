package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private static Stream<Arguments> moveTest() {
        return Stream.of(Arguments.of(1, false),
                Arguments.of(2, false),
                Arguments.of(4, true),
                Arguments.of(9, true));
    }

    @DisplayName("유효한 이름으로 Car 객체 생성시 정상 생성된다")
    @Test
    void Car_유효한_이름_정상_생성된다() {
        assertThatCode(() -> {
            new Car("pobi");
        }).doesNotThrowAnyException();
    }

    @DisplayName("유효하지 않은 Car 객체 생성시 에러가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "ab.de", "   ", ""})
    void Car_유효하지_않은_이름_예외가_발생한다(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("값이 4이상이면 이동, 아니면 이동하지 않는다")
    @ParameterizedTest
    @MethodSource("moveTest")
    void Car_값이_4_이상일때_이동한다(int randomNumber, boolean isMoved) {
        Car pobiCar = new Car("pobi");
        boolean moveResult = pobiCar.move(randomNumber);

        assertThat(moveResult).isEqualTo(isMoved);
    }
}
