package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PlayTimeTest {

    @Test
    public void biggerThanZero() {
        assertThatThrownBy(() -> new PlayTime(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void checkDecrease() {
        PlayTime playTime = new PlayTime(2);
        PlayTime comparePlayTime = new PlayTime(1);
        playTime.decrease();
        assertThat(comparePlayTime).isEqualTo(playTime);
    }

    @Test
    public void isNotEnd() {
        PlayTime playTime = new PlayTime(1);
        boolean endTest = playTime.isEnd();
        assertThat(endTest).isFalse();
    }

    @Test
    public void isEnd() {
        PlayTime playTime = new PlayTime(1);
        playTime.decrease();
        boolean endTest = playTime.isEnd();
        assertThat(endTest).isTrue();
    }
}