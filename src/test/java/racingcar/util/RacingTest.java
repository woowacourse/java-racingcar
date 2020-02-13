package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;

public class RacingTest {

    @DisplayName("자동차 레이싱시 잘 달리고, 달린 정보를 리턴해주는지 확인")
    @Test
    void makeCars() {
        CarNames carNames = new CarNames("aaa,bbb,ccc");
        Cars cars = new Cars(carNames.getCarNames());
        List<Car> racingCars = cars.getCars();
        String progress = Racing.run(racingCars, 10);
        assertThat(progress).contains("aaa :")
            .contains("bbb :")
            .contains("ccc : ")
            .contains("-");
    }
}
