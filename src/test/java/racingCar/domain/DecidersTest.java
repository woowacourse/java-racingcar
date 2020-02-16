package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DecidersTest {
    @Test
    void Deciders() {
        // given
        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 8, 9);

        // when
        Deciders deciders = new Deciders(ints);

        // then
        Assertions.assertThat(deciders.getUnmodifiableList().size())
                .isEqualTo(ints.size());
    }

    @Test
    void Deciders_ShouldThrowException() {
        // given
        List<Integer> ints = Arrays.asList(-1, 0, 2, 5);

        // then
        Assertions.assertThatThrownBy(() -> {

            // when
            Deciders deciders = new Deciders(ints);
        });
    }

    @Test
    void size() {
        // given
        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 8, 9);
        Deciders deciders = new Deciders(ints);

        // when
        int size = deciders.size();

        // then
        Assertions.assertThat(size).isEqualTo(ints.size());
    }
}