package application.racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {
    @Test
    public void splitTest() {
        String input = ",abc";
        String[] expected = {"", "abc"};
        Assertions.assertThat(input.split(",")).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", ",asd", "asdfrq,pobi", "pobi,pobi", "pobi,,crong", "pobi, ,crong"})
//    @ValueSource(strings = {",asd"})
    public void validateInputCarNameTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            CarName carName = new CarName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"","a","-1","a,sd,fd"})
    public void validateInputRacingLab(String input) {
        Assertions.assertThatThrownBy(() -> {
            RacingLab racingLab = new RacingLab(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void moveCarWhenNumberOverFour() {
        Car car = new Car("test");
        int overFourCase = 4;
        int lessFourCase = 0;
        car.moveCarWhenNumberOverFour(overFourCase);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
        car.moveCarWhenNumberOverFour(lessFourCase);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
}
