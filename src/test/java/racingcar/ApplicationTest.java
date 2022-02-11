package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Parser;

public class ApplicationTest {

    @Test
    void 이름_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            Parser.split("abcdef,a,b");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Parser.split(",,");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Parser.split("");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Parser.split(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 라운드_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            Parser.isValidRounds("0");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Parser.isValidRounds("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_전진_테스트() {
        Car car = new Car("test");
        car.move(5);
        assertThat(car.getCurrentPosition()).isEqualTo("test : -");
        car.move(3);
        assertThat(car.getCurrentPosition()).isEqualTo("test : -");
    }

    @Test
    void 최종_우승자_테스트() {
        Cars cars = new Cars(new String[] {"car1","car2","car3"});

        cars.getCars().get(0).move(5);
        cars.getCars().get(1).move(5);
        cars.getCars().get(2).move(3);

        assertThat(cars.getChampions())
            .contains("car1")
            .contains("car2")
            .doesNotContain("car3");
    }
}
