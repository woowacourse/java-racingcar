import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RacingCarTest {
    @Test
    void 자동차에_이름을_부여() {
        RacingCar racingCar = new RacingCar("name");
        assertNotNull(racingCar);
    }

    @Test
    void 자동차는_전진할_수_있다() {
        RacingCar racingCar = new RacingCar("name");
        int position = racingCar.getPostion();
        assertThat(position).isEqualTo(0);

        racingCar.go();
        position = racingCar.getPostion();
        assertThat(position).isEqualTo(1);
    }

    @Test
    void 자동차는_멈출_수_있다() {
        RacingCar racingCar = new RacingCar("name");
        int position = racingCar.getPostion();
        assertThat(position).isEqualTo(0);

        racingCar.stop();
        position = racingCar.getPostion();
        assertThat(position).isEqualTo(0);
    }
}
