import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    @Test
    @DisplayName("레이싱게임 객체를 생성한다")
    void createRacingGame() {
        assertThatCode(RacingGame::fromEmpty).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("횟수가 잘 저장 되는지 확인한다")
    void saveCount() {
        RacingGame racingGame = RacingGame.fromCount(1);
        assertThat(racingGame).extracting("count").isEqualTo(1);
    }

    @Test
    @DisplayName("자동차들이 횟수만큼 잘 움직이는지 확인한다.")
    void play() {
        RacingGame racingGame = RacingGame.fromCount(1);
        racingGame.play();

    }

}