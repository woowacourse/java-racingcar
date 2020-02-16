package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d", "kueni,pobi,jason", "kueni"})
    void init_ShouldReturnTrue(String input) {
        // when
        boolean bool = RacingCar.init(input);

        // then
        Assertions.assertThat(bool)
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,b,d", "kueni,pobi,jason,kueni", ""})
    void init_ShouldReturnFalse(String input) {
        // when
        boolean bool = RacingCar.init(input);

        // then
        Assertions.assertThat(bool)
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d", "kueni,pobi,jason", "kueni"})
    void getPlayerNames(String input) {
        // given
        RacingCar.init(input);

        // when
        List<String> result = RacingCar.getPlayerNames();

        // then
        List<String> expected = Arrays.asList(input.split(","));
        Assertions.assertThat(result.containsAll(expected))
                .isTrue();
        Assertions.assertThat(result.size())
                .isEqualTo(expected.size());
    }

    @Test
    void getPlayerPositions() {
        // given
        String input = "kueni,pobi,jason";
        RacingCar.init(input);

        // when
        List<Integer> result = RacingCar.getPlayerPositions();

        // then
        List<Integer> expected = Arrays.asList(0, 0, 0);
        Assertions.assertThat(result.size())
                .isEqualTo(3);
        Assertions.assertThat(result.containsAll(expected))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d", "kueni,pobi,jason", "kueni"})
    void getWinners(String input) {
        // given
        RacingCar.init(input);

        // when
        List<String> result = RacingCar.getWinners();

        // then
        List<String> expected = Arrays.asList(input.split(","));
        Assertions.assertThat(result.containsAll(expected))
                .isTrue();
        Assertions.assertThat(result.size())
                .isEqualTo(expected.size());
    }
}