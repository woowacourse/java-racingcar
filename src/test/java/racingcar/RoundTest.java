package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Round;

public class RoundTest {
    @Test
    @DisplayName("생성자 테스트")
    void constructor() {
        Assertions.assertThat(new Round(5))
                .isInstanceOf(Round.class);
    }

    @ParameterizedTest
    @DisplayName("생성자에 이동 횟수의 범위가 벗어난 경우")
    @ValueSource(ints = {-1, 0, 101})
    void constructor_이동_횟수의_범위를_벗어난_경우(int totalRound) {
        Assertions.assertThatThrownBy(() -> new Round(totalRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("총 라운드 수가 범위를 벗어났습니다.");
    }

    @Test
    @DisplayName("Round를 1 증가 시키는 메소드 테스트")
    void next() {
        Round round = new Round(5);
        round.next();
        Assertions.assertThat(round.isRoundOf(2))
                .isTrue();
    }

    @Test
    @DisplayName("next를 마지막 라운드에서 호출한 경우")
    void next_마지막_라운드에서_호출한_경우() {
        Round round = new Round(1);
        Assertions.assertThatThrownBy(() -> round.next())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최종 라운드입니다.");
    }

    @Test
    @DisplayName("마지막 라운드인지 여부를 확인")
    void isFinal() {
        Round round = new Round(2);
        round.next();
        Assertions.assertThat(round.isFinal())
                .isTrue();
    }
}
