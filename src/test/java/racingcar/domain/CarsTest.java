package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @DisplayName("자동차 이름들을 주었을 때, 자동차들을 잘 만드는지 확인")
    @Test
    void makeCars() {
        CarNames carNames = new CarNames("aaa,bbb,ccc");
        Cars cars = new Cars(carNames.getCarNames());
        List<Car> racingCars = cars.getCars();
        assertThat(racingCars.get(0).getName()).isEqualTo("aaa");
        assertThat(racingCars.get(1).getName()).isEqualTo("bbb");
        assertThat(racingCars.get(2).getName()).isEqualTo("ccc");
    }
}
