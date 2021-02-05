package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.utils.CarCreatorUtils;

public class CarCreatorUtilsTest {

    @DisplayName("자동차 이름들의 리스트로 자동차 객체들을 만들어 리스트에 담아 반환하는가?")
    @Test
    void createCarsByCarNames() {
        List<String> carNames = new ArrayList<>();

        String firstCarName = "111";
        String secondCarName = "222";
        String thirdCarName = "333";

        carNames.add(firstCarName);
        carNames.add(secondCarName);
        carNames.add(thirdCarName);

        List<Car> createdCars = CarCreatorUtils.createCars(carNames);

        assertThat(createdCars.size()).isEqualTo(3);

        assertThat(createdCars.get(0).getName()).isEqualTo(firstCarName);
        assertThat(createdCars.get(1).getName()).isEqualTo(secondCarName);
        assertThat(createdCars.get(2).getName()).isEqualTo(thirdCarName);
    }
}
