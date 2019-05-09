package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.MovementStrategy;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;

//테스트 파일 나누기

public class RacingCarTest {

    @Test
    void carMoveTest() {
        Car car = new Car("testCar");
        assertThat(car.moveAndReturnPosition(new ForceMove())).isEqualTo(1);
    }

    @Test
    void carInitTest() {
        Car car = new Car("TET", 6);
        assertThat(car.moveAndReturnPosition(new ForceMove())).isEqualTo(7);
    }

    @Test
    void inputFilteringTest() {
        System.out.println(view.filterTypos("ABC, DEF,GS,HF   , SW,,,,,,, SD"));
    }

    @Test
    void nameValidationTestA() {
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

class ForceMove implements MovementStrategy {
    public boolean isMovable() {
        return true;
    }
}