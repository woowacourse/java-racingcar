package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    public void create() {
        final Round round = new Round(1);
        assertThat(round).isEqualTo(new Round(1));
    }

    @Test
    public void 유효성_검사() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Round(-1));
    }

    @Test
    public void 이동() {
        final Round round = new Round(1);
        final Round actual = round.next();
        assertThat(actual).isEqualTo(new Round(0));
    }

}