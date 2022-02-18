package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    @Test
    void save() {
        String name = "범고래";
        int score = 1;
        Score carScore = new Score(name, score);
        assertThat(carScore.getName()).isEqualTo(name);
    }

}
