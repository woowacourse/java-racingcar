package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private static Stream<Arguments> moveTest() {
        return Stream.of(Arguments.of(1, false),
                Arguments.of(2, false),
                Arguments.of(4, true),
                Arguments.of(9, true));
    }

    @Test
    void Car_유효한_이름_정상_생성된다() {
        assertThatCode(() -> {
            new Car("pobi");
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcdef", "ab.de", "   "})
    void Car_유효하지_않은_이름_예외가_발생한다(String name) {
        assertThatThrownBy(() -> {
            new Car(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("moveTest")
    void Car_값이_4_이상일때_이동한다(int randomNumber, boolean isMoved) {
        Car pobiCar = new Car("pobi");
        boolean moveResult = pobiCar.move(randomNumber);

        assertThat(moveResult).isEqualTo(isMoved);
    }

    private static class Car {
        private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]{1,5}");
        private static final int MINIMUM_MOVE_NUMBER = 4;
        private static final int DEFAULT_POSITION = 0;

        private final String name;
        private int position;

        public Car(String name) {
            this.name = name;
            this.position = DEFAULT_POSITION;
            validateName();
        }

        private void validateName() {
            if (Objects.isNull(this.name)) {
                throw new IllegalArgumentException();
            }
            Matcher matcher = PATTERN.matcher(this.name);
            if (!matcher.matches()) {
                throw new IllegalArgumentException();
            }
        }

        public boolean move(int randomNumber) {
            if (randomNumber >= MINIMUM_MOVE_NUMBER) {
                this.position++;
                return true;
            }
            return false;
        }
    }
}
