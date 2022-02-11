package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void getChampionNames_우승자가_한명() {
        RacingGame racingGame = new RacingGame(new String[] {"car1", "car2", "car3"});

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
        RacingGame racingGame = new RacingGame(new String[] {"car1", "car2", "car3"});

        racingGame.getCars().get(0).move(5);
        racingGame.getCars().get(1).move(5);
        racingGame.getCars().get(2).move(3);

        assertThat(racingGame.getChampionNames())
            .contains("car1")
            .contains("car2")
            .doesNotContain("car3");
    }
}