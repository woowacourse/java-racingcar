package racingcar.domain.car;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import racingcar.exception.InvalidNameInputException;

public class CarsTest {

    @Test
    void createCarsBySplitComma() {
        String input = "pobi,seung,char";
        Cars cars = new Cars(input);
        List<Car> carList = cars.getCarList();
        Assertions.assertThat(carList.size()).isEqualTo(3);
        Assertions.assertThat(carList.get(0)).isEqualTo(new Car("pobi"));
        Assertions.assertThat(carList.get(1)).isEqualTo(new Car("seung"));
        Assertions.assertThat(carList.get(2)).isEqualTo(new Car("char"));
    }

    @Test
    void errorOnContinuousComma() {
        String input = ",,,";
        Assertions.assertThatThrownBy(() -> {
                new Cars(input);
            }).isInstanceOf(InvalidNameInputException.class)
            .hasMessageContaining("자동차 이름에 ,만 사용할 수 없습니다.");
    }
}
