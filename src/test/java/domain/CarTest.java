package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("자동차의 ")
class CarTest {

    @ParameterizedTest(name = "이름이 {0}면 생성 불가능")
    @ValueSource(strings = {"", "applej", "한글로여섯자", "***%^$"})
    void 길이가_1미만_5초과인_차는_예외_발생(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 1 ~ 5 글자여야 합니다");
    }

    @ParameterizedTest(name = "이름이 {0}면 생성 가능")
    @ValueSource(strings = {"a", "apple", "한글다섯자", "&"})
    void 길이가_1미만_5초과인_차는_예외_미발생(String name) {
        assertThatNoException().isThrownBy(() -> new Car(name));
    }

    @ParameterizedTest(name = "이동 인자가 {0}이 들어오면 전진한다.")
    @ValueSource(ints = {4, 5, 6, 9})
    void 자동차_전진_테스트(int number) {
        Car car = new Car("임시");
        int previous = car.getPosition();

        car.move(number);

        assertThat(car.getPosition()).isEqualTo(previous+1);
    }

    @ParameterizedTest(name = "이동 인자가 {0}이 들어오면 전진하지 않는다.")
    @ValueSource(ints = {0, 2, 3})
    void 자동차_정지_테스트(int number) {
        Car car = new Car("임시");
        int previous = car.getPosition();

        car.move(number);

        assertThat(car.getPosition()).isEqualTo(previous);
    }
}