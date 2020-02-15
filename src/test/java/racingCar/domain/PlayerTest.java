package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void goOrWait(int input) {
        Player player = new Player(new Name("kueni"));
        int result = 0;
        for (int i = 0; i < input; i++) {
            result = player.goOrWait(true);
        }
        Assertions.assertThat(result).isEqualTo(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,kueni : -", "2,kueni : --"})
    void testToString(int input, String expected) {
        Player player = new Player(new Name("kueni"), input);
        Assertions.assertThat(player.toString().equals(expected))
                .isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,3,-2", "3,1,2", "2,2,0"})
    void compare(int a, int b, int expected) {
        Player player = new Player(new Name("kueni"), a);
        Player other = new Player(new Name("pobi"), b);
        Assertions.assertThat(Player.compare(player, other))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3,true", "3,2,false"})
    void isWinner(int position, int max, boolean expected) {
        Player player = new Player(new Name("kueni"), position);
        Assertions.assertThat(player.isWinner(max))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"kueni", "pobi", "CU"})
    void getName(String input) {
        Player player = new Player(new Name(input), 3);
        Assertions.assertThat(player.getName().equals(input))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void getPosition(int input) {
        Player player = new Player(new Name("kueni"), input);
        Assertions.assertThat(player.getPosition())
                .isEqualTo(input);
    }

}