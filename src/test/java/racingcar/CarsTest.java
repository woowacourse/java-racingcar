package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    void 자동차_입력시_공백이_들어간_경우() {
        final String actual = "bom, sun";
        final List<String> expected = Arrays.asList("bom", "sun");
        assertThat(Cars.splitCars(actual)).isEqualTo(expected);
    }

    @Test
    void 자동차_이름이_하나도_존재하지_않을_경우_예외처리() {
        assertThatThrownBy(() -> {
            Cars.splitCars("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차의_이름이_5자_이상인_경우_예외처리() {
        assertThatThrownBy(() -> {
            Cars.splitCars("asd,qwerty");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름에_중복이_존재하는_경우_예외처리() {
        assertThatThrownBy(() -> {
            Cars.splitCars("aaa,bbb,aaa");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차의_이름이_공백인_경우_예외처리() {
        assertThatThrownBy(() -> {
            Cars.splitCars(" , , ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름이 존재하지 않습니다.");
    }

//    @Test
//    void 자동차_객체_생성() {
//        List<String> actual = Arrays.asList("bom", "sun");
//        String given = "bom,sun";
//        Cars cars = Cars.initCars(given);
//        List<String> expected = cars.getCars().stream()
//                .map(Car::getName)
//                .collect(Collectors.toList());
//
//        assertThat(expected).isEqualTo(actual);
//    }

    @Test
    void 우승자_자동차_확인() {
        Car car1 = new Car("bom", 3);
        Car car2 = new Car("sun", 4);
        Car car3 = new Car("asdf", 4);
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        assertThat(cars.findWinnerCars().getCars().size()).isEqualTo(2);
    }
}
