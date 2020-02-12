package racingcargame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    void 자동차_생성() {
        String[] carNames = new String[]{"pobi", "jason"};
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        assertThat(carList.size()).isEqualTo(2);
    }
}
