import org.junit.jupiter.api.Test;
import racingCar.domain.errors.InvalidInputException;
import racingCar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RacingCarTest {
    @Test
    void 자동차에_이름을_부여() {
        RacingCar racingCar = new RacingCar("name");
        assertNotNull(racingCar);
    }

    @Test
    void 자동차의_이름은_5자_이하만_가능하다() {
        String nameWhichLengthIsUnder5 = "name";
        RacingCar racingCar = new RacingCar(nameWhichLengthIsUnder5);
        assertNotNull(racingCar);

        String nameWhichLengthIsOver5 ="nameee";
        assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> {
                    new RacingCar(nameWhichLengthIsOver5);
                }).withMessage("이름은 최대 길이인 5를 넘을 수 없습니다.");

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
    void 주어진_횟수동안_N대의_자동차는_전진할_수_있다() {
        int givenNumberToGo = 5;
        int N = 3;
        for (int i = 0; i < N; i++) {
            String name = String.valueOf(i);
            RacingCar racingCar = new RacingCar(name);
            assertThat(racingCar.getPostion()).isEqualTo(0);
            racingCar.goManyTimesAsRandom(givenNumberToGo, 4);
            assertThat(racingCar.getPostion()).isEqualTo(givenNumberToGo);
        }
    }


    @Test
    void 전진하는_자동차를_출력_시_이름이_출력되도록_자동차를_문자화할때_이름을_리턴한다() {
        RacingCar racingCar = new RacingCar("name");
        assertThat(racingCar.toString()).isEqualTo("name");
    }

    @Test
    void 임의의_숫자가_4이상일_경우_전진한다() {
        RacingCar racingCar = new RacingCar("name");
        int position = racingCar.getPostion();
        assertThat(position).isEqualTo(0);

        racingCar.goWithNumberOverFour(4);
        position = racingCar.getPostion();
        assertThat(position).isEqualTo(1);
    }
}
