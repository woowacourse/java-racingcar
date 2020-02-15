package racingcar.domain.car;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    void 자동차의_이름들이_빈_문자열인_경우_예외_처리() {
        String input = "";
        assertThatThrownBy(() -> {
            Cars.validateNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차의_이름이_중복되는_경우_예외_처리() {
        String input = "무늬, 무늬,  무늬 ";
        assertThatThrownBy(() -> {
            Cars.validateDuplicatedNames(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차의_이름들로_Car_객체를_생성하는_기능() {
        String inputForCarNames = "무늬, 두강";
        List<Car> cars = Cars.generateCarsByInput(inputForCarNames);
        assertThat(cars.size()).isEqualTo(2);


        inputForCarNames = "무늬, 두강, 쿨라임, 코일";
        cars = Cars.generateCarsByInput(inputForCarNames);
        assertThat(cars.size()).isEqualTo(4);
    }
}
