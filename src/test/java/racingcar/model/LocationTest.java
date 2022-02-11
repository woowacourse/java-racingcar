package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LocationTest {

    @Test
    public void isZeroWhenStarted() {
        Location location = new Location();
        assertThat(location.getCurrentPosition()).isEqualTo(0);
    }

    @Test
    public void increase() {
        Location location = new Location();
        location.increase();
        assertThat(location.getCurrentPosition()).isEqualTo(1);
    }
}