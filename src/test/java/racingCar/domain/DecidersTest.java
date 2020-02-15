package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DecidersTest {
    Players players;

    @BeforeEach
    void setUp() {
        players = new Players("kueni,pobi,jason");
    }

    @Test
    void decidePlayerGoOrWait() {
        Deciders deciders = new Deciders(players);
        deciders.decidePlayerGoOrWait();
        System.out.println(deciders);
    }

    @Test
    void isNotEqualSize_ShouldFalseWhenSizeIsEqual() {
        Deciders deciders = new Deciders(players);
        Assertions.assertThat(deciders.isNotEqualSize(players))
                .isFalse();
    }

    @Test
    void isNotEqualSize_ShouldTrueWhenSizeIsNotEqual() {
        Players other = new Players("kueni, pobi");
        Deciders deciders = new Deciders(other);
        Assertions.assertThat(deciders.isNotEqualSize(players))
                .isTrue();
    }

    @Test
    void get_ShouldTrue() {
        List<Boolean> booleans = getBooleans(true);
        Deciders deciders = new Deciders(players, booleans);
        Assertions.assertThat(deciders.get(1))
                .isTrue();
    }

    @Test
    void get_ShouldFalse() {
        List<Boolean> booleans = getBooleans(false);
        Deciders deciders = new Deciders(players, booleans);
        Assertions.assertThat(deciders.get(1))
                .isFalse();
    }

    private List<Boolean> getBooleans(boolean bool) {
        List<Boolean> booleans = new ArrayList<>();
        for (Player player: players.getUnmodifiableList()) {
            booleans.add(bool);
        }
        return booleans;
    }
}