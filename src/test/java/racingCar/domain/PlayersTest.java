package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PlayersTest {
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void play(int input) {
        List<Name> names = StringParser.parseToNameList("pobi,jason,cu");
        Players players = new Players(names);
        List<Boolean> trueBooleans = new ArrayList<>();
        for (Player ignored : players.getUnmodifiableList()) {
            trueBooleans.add(true);
        }
        Deciders deciders = new Deciders(players, trueBooleans);
        List<Player> results = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            results = players.play(deciders);
        }
        for (Player t : results) {
            Assertions.assertThat(t.getPosition()).isEqualTo(input);
        }
    }

    @Test
    void isEmpty_ShouldReturnFalseWhenInputAreDuplicatedNames() {
        String input = "abc,abc";
        List<Name> names = StringParser.parseToNameList(input);
        Players gameManager = new Players(names);

        Assertions.assertThat(gameManager.isEmpty())
                .isTrue();
    }

    @Test
    void getUnmodifiableList() {
        String input = "kueni,pobi";
        List<Name> names = StringParser.parseToNameList(input);
        Players players = new Players(names);
        Assertions.assertThat(players.getUnmodifiableList().size())
                .isEqualTo(2);
    }
}
