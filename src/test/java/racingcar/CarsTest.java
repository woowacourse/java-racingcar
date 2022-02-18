package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

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

    @Test
    void 자동차_객체_생성() {
        List<String> actual = Arrays.asList("bom", "sun");
        String given = "bom, sun";
        Cars cars = Cars.initCars(given);
        List<String> expected = cars.getCars().stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(expected).isEqualTo(actual);
    }
}
