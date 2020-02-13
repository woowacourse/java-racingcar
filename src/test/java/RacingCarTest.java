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

    @Test
    void 주어진_횟수동안_N대의_자동차는_전진할_수_있다() {
        int givenNumberToGo = 5;
        int N = 3;
        for (int i = 0; i < N; i++) {
            String name = String.valueOf(i);
            RacingCar racingCar = new RacingCar(name);
            assertThat(racingCar.getPostion()).isEqualTo(0);
            racingCar.goManyTimes(givenNumberToGo);
            assertThat(racingCar.getPostion()).isEqualTo(givenNumberToGo);
        }
    }

    @Test
    void 주어진_횟수동안_N대의_자동차는_멈출_수_있다() {
        int givenNumberToStop = 5;
        int N = 3;
        for (int i = 0; i < N; i++) {
            String name = String.valueOf(i);
            RacingCar racingCar = new RacingCar(name);
            assertThat(racingCar.getPostion()).isEqualTo(0);
            racingCar.stopManyTimes(givenNumberToStop);
            assertThat(racingCar.getPostion()).isEqualTo(0);
        }
    }
}
