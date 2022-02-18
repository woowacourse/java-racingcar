package racingcar.model.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {
    @Test
    @DisplayName("이름과 점수를 입력 받아서 저장한다.")
    void save() {
        String name = "범고래";
        int point = 1;
        Score carScore = new Score(name, point);
        assertThat(carScore.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("점수가 같은지 확인한다.")
    void matchScore() {
        String name = "범고래";
        int point = 1;
        Score carScore = new Score(name, point);
        assertThat(carScore.matchScore(1)).isTrue();
    }
}
