package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.MovableStrategy;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    void moveTest() {
        Car car = new Car("testCar");
        car.move(new ForceMove());
    }

    @Test
    void inputFilteringTest() {
        InputView view = new InputView();
        System.out.println(view.filterTypos("ABC, DEF,GS,HF   , SW,,,,,,, SD"));
    }

    @Test
    void nameValidationTestA() {
        InputView view = new InputView();
        String arg = "";
        assertThat(view.areInvalidNames(view.filterTypos(arg))).isEqualTo(true);
    }

    @Test
    void nameValidationTestB() {
        InputView view = new InputView();
        String arg = "asd,asd";
        assertThat(view.areInvalidNames(view.filterTypos(arg))).isEqualTo(true);
    }

    @Test
    void nameValidationTestC() {
        InputView view = new InputView();
        String arg = "asd,gh,qwr,fj,ashdhrshrd";
        assertThat(view.areInvalidNames(view.filterTypos(arg))).isEqualTo(true);
    }

    @Test
    void nameValidationTestD() {
        InputView view = new InputView();
        String arg = "asd,gh,qwr,fj,rd";
        assertThat(view.areInvalidNames(view.filterTypos(arg))).isEqualTo(false);
    }


}

class ForceMove implements MovableStrategy {
    public boolean isMovable() {
        return true;
    }
}