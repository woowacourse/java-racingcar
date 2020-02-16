package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void goOrWait(int input) {
        Decider decider = new Decider(5);
        Player player = new Player(new Name("kueni"));
        int result = 0;
        for (int i = 0; i < input; i++) {
            result = player.goOrWait(decider);
        }
        Assertions.assertThat(result).isEqualTo(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3,true", "3,2,false"})
    void isWinner(int position, int max, boolean expected) {
        Decider decider = new Decider(5);
        Player player = new Player(new Name("kueni"));
        for (int i = 0; i < position; i++) {
            player.goOrWait(decider);
        }
        Assertions.assertThat(player.isWinner(max))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"kueni", "pobi", "CU"})
    void getName(String input) {
        Player player = new Player(new Name(input));
        Assertions.assertThat(player.getName().equals(input))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void getPosition(int input) {
        Player player = new Player(new Name("kueni"));
        for (int i = 0; i < input; i++) {
            player.goOrWait(new Decider(5));
        }
        Assertions.assertThat(player.getPosition())
                .isEqualTo(input);
    }

}