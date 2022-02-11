package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.exception.CarNamesNotOnlyCommaException;

class CarsTest {

    @Test
    void createCarsBySplitComma() {
        String input = "pobi,seung,char";
        Cars cars = new Cars(input);
        List<Car> carList = cars.getCarList();
        assertThat(carList.size()).isEqualTo(3);
        assertThat(carList.get(0)).isEqualTo(new Car("pobi"));
        assertThat(carList.get(1)).isEqualTo(new Car("seung"));
        assertThat(carList.get(2)).isEqualTo(new Car("char"));
    }

    @Test
    void errorOnContinuousComma() {
        String input = ",,,";
        assertThatThrownBy(() -> {
            new Cars(input);
        }).isInstanceOf(CarNamesNotOnlyCommaException.class)
            .hasMessageContaining("자동차 이름에 ,만 사용할 수 없습니다.");
    }
}
