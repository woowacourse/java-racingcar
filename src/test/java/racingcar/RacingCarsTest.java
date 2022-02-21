package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.RacingCars;

public class RacingCarsTest {

    @Test
    @DisplayName("자동차가 한대 있을때 예외처리가 정상적으로 동작하는지 확인")
    public void validateCar_자동차한대() {
        List<String> carNames = new ArrayList<>(Arrays.asList("pobi"));
        assertThatThrownBy(() -> new RacingCars(carNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 자동차이름이 들어올때 예외처리가 정상적으로 동작하는지 확인")
    public void validateCar_중복된이름() {
        List<String> carNames = new ArrayList<>(Arrays.asList("pobi", "josh", "pobi"));
        assertThatThrownBy(() -> new RacingCars(carNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 리스트가 null일때 예외던지는지 확인")
    public void validateCar_null() {
        assertThatThrownBy(() -> new RacingCars(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
