package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 10})
    void goOrWait(int input) {
        // given
        Decider decider = new Decider(5);
        Player player = new Player(new Name("kueni"));

        // when
        int result = 0;
        for (int i = 0; i < input; i++) {
            result = player.goOrWait(decider);
        }

        // then
        Assertions.assertThat(result).isEqualTo(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3,true", "3,2,false"})
    void isWinner(int position, int max, boolean expected) {
        // given
        Decider decider = new Decider(5);
        Player player = new Player(new Name("kueni"));
        for (int i = 0; i < position; i++) {
            player.goOrWait(decider);
        }

        // when
        boolean result = player.isWinner(max);

        // then
        Assertions.assertThat(result)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"kueni", "pobi", "CU"})
    void getName(String input) {
        // given
        Name name = new Name(input);
        Player player = new Player(name);

        // when
        Name result = player.getName();

        // then
        Assertions.assertThat(result.equals(name))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 10})
    void getPosition(int input) {
        // given
        Player player = new Player(new Name("kueni"));
        for (int i = 0; i < input; i++) {
            player.goOrWait(new Decider(5));
        }

        // when
        int result = player.getPosition();

        // then
        Assertions.assertThat(result)
                .isEqualTo(input);
    }

}