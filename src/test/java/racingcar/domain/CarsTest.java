package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @DisplayName("이름이 중복되지 않는 경우 Cars 객체를 생성한다")
    @Test
    public void createCars() {
        List<String> carNames = Arrays.asList(new String[]{"dani", "pobi", "bear"});

        assertThatCode(() -> new Cars(carNames))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름이 중복되는 경우 예외를 발생시킨다")
    @Test
    public void createCarsException() {
        List<String> carNames = Arrays.asList(new String[]{"dani", "pobi", "dani", "bear"});

        assertThatThrownBy(() -> {
            new Cars(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
