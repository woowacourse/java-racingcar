package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import racingcar.Parser;

class RacingGameTest {

    @Test
    void validateNames_쉼표만() {
        assertThatThrownBy(() -> {
            new RacingGame(Arrays.asList());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getChampionNames_우승자가_한명() {
        RacingGame racingGame = new RacingGame(Arrays.asList("car1", "car2", "car3"));

        racingGame.getCars().get(0).move(5);
        racingGame.getCars().get(1).move(1);
        racingGame.getCars().get(2).move(3);

        assertThat(racingGame.getChampionNames())
            .contains("car1")
            .doesNotContain("car2")
            .doesNotContain("car3");
    }

    @Test
    void getChampionNames_우승자가_여러명() {
        RacingGame racingGame = new RacingGame(Arrays.asList("car1", "car2", "car3"));

        racingGame.getCars().get(0).move(5);
        racingGame.getCars().get(1).move(5);
        racingGame.getCars().get(2).move(3);

        assertThat(racingGame.getChampionNames())
            .contains("car1")
            .contains("car2")
            .doesNotContain("car3");
    }
}