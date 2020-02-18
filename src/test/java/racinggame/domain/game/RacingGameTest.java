package racinggame.domain.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racinggame.domain.TestMovableStrategy;
import racinggame.domain.data.Names;
import racinggame.domain.data.Repeat;

import java.util.List;
import java.util.Map;

public class RacingGameTest {
    Names names = new Names("pobi,crong,honux");
    Repeat repeat = new Repeat("5");
    RacingGame racingGame = new RacingGame(names, new TestMovableStrategy());
    /**
     * 임의로 모든 차가 전진만 100% 하도록 인터페이스를 변경하여 생성하였다.
     * 그렇기 떄문에, 실제 이 게임의 경우 세 플레이어 모두 전진하여, 셋 모두 우승자임이 분명해진다.
     */
    @Test
    void 레이싱게임_이동_테스트(){
        Map<String, Integer> gameLog;
        racingGame.moveCars();
        gameLog = racingGame.moveCars();
        Assertions.assertThat(gameLog.get("pobi")).isEqualTo(2);
        Assertions.assertThat(gameLog.get("pobi")).isEqualTo(2);
        Assertions.assertThat(gameLog.get("pobi")).isEqualTo(2);
    }
    @Test
    void 레이싱게임_승자_테스트() {
        for (int repeatIterator = 0; repeat.isLoopDone(repeatIterator); repeatIterator++) {
            racingGame.moveCars();
        }
        List<String> winners = racingGame.getWinners();
        Assertions.assertThat(winners.contains("pobi")).isTrue();
        Assertions.assertThat(winners.contains("crong")).isTrue();
        Assertions.assertThat(winners.contains("honux")).isTrue();
    }
}
