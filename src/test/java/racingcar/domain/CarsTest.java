package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private final List<String> carNames = Arrays.asList("carA", "carB", "carC", "carD");

    @Test
    @DisplayName("전체 전진")
    void proceedAll() {
        Cars cars = new Cars(carNames);
        cars.proceedAll(() -> true);
        List<Car> proceedCars = cars.getCarsHere(1);
        assertThat(proceedCars.size()).isEqualTo(carNames.size());
    }

    @Test
    @DisplayName("자동차 위치 최댓값")
    void findMaxPosition() {
        Cars cars = new Cars(carNames);
        List<Car> initCars = cars.getCarsHere(0);
        initCars.get(0).proceed(() -> true);
        initCars.get(0).proceed(() -> true);
        initCars.get(1).proceed(() -> true);
        assertThat(cars.findMaxPosition()).isEqualTo(2);
    }
    
    @Test
    @DisplayName("검증 체크 - Blank")
    void checkValidateBlank() {
        assertThatThrownBy(() -> new Cars(Arrays.asList("  ", "carA"))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("검증 체크 - null")
    void checkValidateNull() {
        assertThatThrownBy(() -> new Cars(Arrays.asList(null, "carA"))).isInstanceOf(IllegalArgumentException.class);
    }
}
