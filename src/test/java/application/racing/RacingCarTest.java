package application.racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class RacingCarTest {
    @Test
    public void splitTest() {
        String input = ",abc";
        String[] expected = {"", "abc"};
        Assertions.assertThat(input.split(",")).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", ",asd", "asdfrq,pobi", "pobi,pobi", "pobi,,crong", "pobi, ,crong", "  ,pobi"})
    public void validateInputCarNameTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            CarName carName = new CarName(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "-1", "a,sd,fd"})
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

    @Test
    public void generateRandomNumberTest() {
        Racing racing = new Racing();
        int randomNumber = racing.generateRandomNumber();
        Assertions.assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    public void findWinner() {
        List<Car> cars = new ArrayList<>();
        Car pobi = new Car("pobi");
        Car lavin = new Car("lavin");
        Car ramen = new Car("ramen");
        pobi.moveCarWhenNumberOverFour(4);
        pobi.moveCarWhenNumberOverFour(4);
        lavin.moveCarWhenNumberOverFour(4);
        lavin.moveCarWhenNumberOverFour(4);
        ramen.moveCarWhenNumberOverFour(4);
        cars.add(pobi);
        cars.add(lavin);
        cars.add(ramen);
        Racing racing = new Racing();
        List<String> winners = new ArrayList<>();
        winners.add("pobi");
        winners.add("lavin");
        Assertions.assertThat(racing.findWinner(cars)).isEqualTo(winners);
    }
}
