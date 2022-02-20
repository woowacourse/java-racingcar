package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.Car;

class CarMakerUtilTest {

    @DisplayName("createCarsWith() 테스트")
    @Test
    void createCarsWith_test() {
        String[] inputNames = {"name1", "name2"};
        List<Car> cars = CarMakerUtil.createCarsWith(inputNames);
        assertThat(cars.size()).isEqualTo(inputNames.length);
    }
}
