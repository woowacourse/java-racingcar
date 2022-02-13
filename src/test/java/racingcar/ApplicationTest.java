package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.RoundValidator;

public class ApplicationTest {

    @Test
    void split_exceeding_5() {
        assertThatThrownBy(() -> {
            GameController.split("abcdef,a,b");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void split_only_with_delimiter() {
        assertThatThrownBy(() -> {
            GameController.split(",,");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void split_blank_input() {
        assertThatThrownBy(() -> {
            GameController.split("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void split_null() {
        assertThatThrownBy(() -> {
            GameController.split(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_0() {
        assertThatThrownBy(() -> {
            RoundValidator.validate("0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_non_digit() {
        assertThatThrownBy(() -> {
            RoundValidator.validate("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void updateMaxPosition() {
        Car car = new Car("test", 0);
        assertThat(car.updateMaxPosition(5)).isEqualTo(5);
    }

    @Test
    void isMaxPosition() {
        Car car = new Car("test", 3);
        assertThat(car.isMaxPosition(3)).isTrue();
    }

    @Test
    void getProgress_move() {
        Car car = new Car("test", 0);
        car.move(5);
        assertThat(car.getProgress()).isEqualTo("test : -");
    }

    @Test
    void getProgress_stop() {
        Car car = new Car("test", 0);
        car.move(3);
        assertThat(car.getProgress()).isEqualTo("test : ");
    }

    @Test
    void getChampionList() {
        Cars cars = new Cars(new String[] {"car1", "car2", "car3"});

        cars.getCars().get(0).move(5);
        cars.getCars().get(1).move(5);
        cars.getCars().get(2).move(3);

        assertThat(cars.getChampionList())
            .contains("car1")
            .contains("car2")
            .doesNotContain("car3");
    }
}
