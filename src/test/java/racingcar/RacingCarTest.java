package racingcar;

import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.CarController;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 이름을 쉼표로 구분하여 저장")
    public void saveCarNames() {
        final CarController controller = new CarController(new Scanner(System.in));
        final List<Car> cars = controller.saveCars("pobi,crong,honux");
        assertThat(cars.get(0).getName().equals("pobi")).isTrue();
    }
}
