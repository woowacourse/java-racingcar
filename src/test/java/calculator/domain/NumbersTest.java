package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumbersTest {
    @Test
    void sum() {
        assertThat(new Numbers(new String[] {"1", "2", "3"}).sum()).isEqualTo(6);
    }

    @ParameterizedTest
    @MethodSource("stringArrayProvider")
    void error(String[] input) {
        assertThatThrownBy(() -> {
            new Numbers(input);
        }).isInstanceOf(RuntimeException.class);
    }

    static Stream<Arguments> stringArrayProvider() {
        return Stream.of(
            Arguments.of((Object)new String[] {"1", "-1"}),
            Arguments.of((Object)new String[] {"1", "2", "d"})
        );
    }
}
