package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class CarTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final int REPEAT = 100;

    @BeforeEach
    void setOutPrintStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void outPutStreamReset() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 자동차_이름을_저장할_수_있다() {
        // given
        String carName = "Jinho";
        Car car = new RandomMovingCar(carName, new RangedRandomNumberPicker(0, 9));

        // when
        String result = car.getName();

        // then
        assertThat(result).isEqualTo(carName);
    }

    @RepeatedTest(REPEAT)
    void 자동차는_진행_가능_범위에서_진행할_수_있다() {
        // given
        final int FROM = 4;
        final int TO = 9;

        RangedRandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(FROM, TO);
        Car car = new RandomMovingCar("jinho", randomNumberPicker);

        // when
        car.race();
        car.race();
        car.race();

        // then
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @RepeatedTest(REPEAT)
    void 자동차는_진행_불가능_범위에서_진행할_수_없다() {
        // given
        final int FROM = 0;
        final int TO = 3;

        RangedRandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(FROM, TO);
        Car car = new RandomMovingCar("jinho", randomNumberPicker);

        // when
        car.race();
        car.race();
        car.race();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_진행_가능_범위_포지션_출력() {
        // given
        final int FROM = 4;
        final int TO = 9;

        String name = "jinho";
        RangedRandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(FROM, TO);
        Car car = new RandomMovingCar(name, randomNumberPicker);

        // when
        car.race();
        car.race();
        car.race();
        car.race();

        car.printCurrentPosition();

        // then
        assertThat(output.toString().trim()).isEqualTo(name + " : ----");
    }

    @Test
    void 자동차_진행_불가능_범위_포지션_출력() {
        // given
        final int FROM = 0;
        final int TO = 3;

        String name = "jinho";
        RangedRandomNumberPicker randomNumberPicker = new RangedRandomNumberPicker(FROM, TO);
        Car car = new RandomMovingCar(name, randomNumberPicker);

        // when
        car.race();
        car.race();
        car.race();
        car.race();

        car.printCurrentPosition();

        // then
        assertThat(output.toString().trim()).isEqualTo(name + " :");
    }
}
