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
        String names = "pobi,jason,cu";
        Players players = new Players(names);
        List<Boolean> trueBooleans = new ArrayList<>();
        for (Player player: players.getUnmodifiableList()) {
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

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    void isEmpty_ShouldReturnTrueWhenInputInvalidName(String input) {
        Players gameManager = new Players(input);
        Assertions.assertThat(gameManager.isEmpty())
                .isTrue();
    }

    @Test
    void isEmpty_ShouldReturnFalseWhenInputVaildName() {
        String input = "abcac"; // "a"
        Players gameManager = new Players(input);

        Assertions.assertThat(gameManager.isEmpty())
                .isFalse();
    }

    @Test
    void isEmpty_ShouldReturnFalseWhenInputDuplicatedNames() {
        String input = "abc,abc";
        Players gameManager = new Players(input);

        Assertions.assertThat(gameManager.isEmpty())
                .isTrue();
    }

    @Test
    void getUnmodifiableList() {
        Players players = new Players("kueni,pobi");
        Assertions.assertThat(players.getUnmodifiableList().size())
                .isEqualTo(2);
    }
}
