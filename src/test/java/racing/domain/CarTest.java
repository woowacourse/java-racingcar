package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

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

    private static class Car {
        private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]{1,5}");

        private final String name;

        public Car(String name) {
            this.name = name;
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
    }
}
