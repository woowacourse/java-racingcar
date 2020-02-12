package racingcar;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    Car car = new Car();

    @Test
    void 유저들_이름_나누기() {
        //given
        String inputNames = "123,324,456";
        List<String> expectedNameList = List.of("123", "324", "456");
        //the
        assertThat(car.splitNames(inputNames)).isEqualTo(expectedNameList);
    }

    @Test
    void 전진() {
        //given
        int state = car.getPosition();
        //when
        car.moveForward();
        //then
        assertThat(car.getPosition()).isEqualTo(state + 1);
    }

    @Test
    void 랜덤값이_4인경우_전진() {
        //given
        int value = 4;
        int state = car.getPosition();
        //when
        car.moveCarAccordingToCondition(value);
        //then
        assertThat(car.getPosition()).isEqualTo(state + 1);
    }
}