package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingGame racingGame;

    @BeforeEach
    void setup() {
        racingGame = new RacingGame();
    }

    @Test
    void 자동차추가() {
        String[] carNames1 = {"a", "b", "c"};
        String[] carNames2 = {"e", "f"};

        racingGame.addCars(carNames1);
        assertThat(racingGame.getCars().size()).isEqualTo(3);

        racingGame.addCars(carNames2);
        assertThat(racingGame.getCars().size()).isEqualTo(5);
    }

//    @Test
//    void 글자길이제한() {
//        String name1 = "a";
//        String name2 = "bbbbb";
//        String name3 = "cccccc";
//
//        assertThat(racingGame.checkStringLengthLimit(name1)).isEqualTo(true);
//        assertThat(racingGame.checkStringLengthLimit(name2)).isEqualTo(true);
//        assertThat(racingGame.checkStringLengthLimit(name3)).isEqualTo(false);
//    }
}
