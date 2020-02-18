package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.utils.StringParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class PlayersTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc,abc", "b,cvd,a,cvd,e"})
    void isReady_ShouldReturnFalseWhenInputAreDuplicatedNames(String input) {
        // given
        List<Name> names = StringParser.parseToNameList(input);
        List<Player> given = names
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());

        // when
        Players gameManager = new Players(given);

        // then
        Assertions.assertThat(gameManager.isReady())
                .isFalse();
    }

    @Test
    void getWinners() {
        // given
        String input = "a,b,c,d";
        List<Name> names = StringParser.parseToNameList(input);
        List<Player> given = names
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());

        Players players = new Players(given);
        players.getUnmodifiableList().get(0).goOrWait(new Decider(5));
        players.getUnmodifiableList().get(1).goOrWait(new Decider(5));
        players.getUnmodifiableList().get(1).goOrWait(new Decider(5));
        players.getUnmodifiableList().get(3).goOrWait(new Decider(5));
        players.getUnmodifiableList().get(3).goOrWait(new Decider(5));

        // when
        List<Player> winners = players.getWinners();

        // then
        Assertions.assertThat(winners.size())
                .isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"a,b,c/3", "kueni,pobi,jason,cu,woni,jun/6"}, delimiter = '/')
    void getUnmodifiableList(String input, int expected) {
        // given
        List<Name> names = StringParser.parseToNameList(input);
        List<Player> given = names
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
        Players players = new Players(given);

        // when
        List<Player> result = players.getUnmodifiableList();

        // then
        Assertions.assertThat(result.size())
                .isEqualTo(expected);
        Assertions.assertThatThrownBy(() -> {
           result.add(new Player(new Name("woowa")));
        });
    }

    @Test
    void equals() {
        // given
        String input = "kueni";
        String input2 = "pobi";
        Player a = new Player(new Name(input));
        Player b = new Player(new Name(input2));
        Players c = new Players(Arrays.asList(a, b));
        Players d = new Players(Arrays.asList(new Player(new Name(input)), new Player(new Name(input2))));

        // when
        boolean bool = c.equals(d);

        // then
        Assertions.assertThat(bool).isTrue();
    }
}
