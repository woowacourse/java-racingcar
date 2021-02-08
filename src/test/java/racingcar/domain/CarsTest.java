package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @DisplayName("이름이 중복되지 않는 경우 객체 생성 성공")
    @Test
    public void createCars_이름이_중복되지_않는_경우() {
        List<String> carNames = Arrays.asList(new String[]{"dani", "pobi", "bear"});

        assertThatCode(() -> new Cars(carNames))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름이 중복되는 경우 예외 발생")
    @Test
    public void createCars_이름이_중복되는_경우() {
        List<String> carNames = Arrays.asList(new String[]{"dani", "pobi", "dani", "bear"});

        assertThatThrownBy(() -> {
            new Cars(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}