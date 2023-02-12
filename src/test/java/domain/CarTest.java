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
    @DisplayName("디폴트 위치는 0이다")
    @Test
    void 생성자_위치_명시하지_않으면_초기위치_0이다() {
        assertThat(new Car("test").getPosition()).isEqualTo(0);
    }

    @ParameterizedTest(name = "이름이 {0}면 생성 불가능")
    @ValueSource(strings = {"", "applej", "한글로여섯자", "***%^$", " "})
    void 이름길이가_1미만_5초과면_예외_발생(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 1 ~ 5 글자여야 합니다");
    }

    @ParameterizedTest(name = "이름이 {0}면 생성 가능")
    @ValueSource(strings = {"a", "apple", "한글다섯자", "&"})
    void 이름길이가_1이상_5이하면_정상_생성(String name) {
        assertThatNoException().isThrownBy(() -> new Car(name));
    }

    @ParameterizedTest(name = "위치가 {0}면 생성 불가능")
    @ValueSource(ints = {-1, -3})
    void 위치가_음수면_예외_발생(int position) {
        assertThatThrownBy(() -> new Car("test", position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치는 0 이상 이어야 합니다.");
    }

    @ParameterizedTest(name = "위치가 {0}면 생성 가능")
    @ValueSource(ints = {0, 1, 100, 1000000})
    void 위치가_양수면_정상_생성(int position) {
        assertThatNoException().isThrownBy(() -> new Car("test", position));
    }

    @ParameterizedTest(name = "이동 숫자가 {0}이 들어오면 전진한다.")
    @ValueSource(ints = {4, 5, 8, 9})
    void 이동_숫자가_4이상_9이하면_전진(int number) {
        Car car = new Car("Move");
        int previous = car.getPosition();

        car.move(number);

        assertThat(car.getPosition()).isEqualTo(previous + 1);
    }

    @ParameterizedTest(name = "이동 숫자가 들어온 횟수만큼 전진한다.")
    @ValueSource(ints = {2, 3, 4, 100})
    void 이동_숫자가_들어온_횟수만큼_전진(int times) {
        Car car = new Car("Move");
        int previous = car.getPosition();

        for (int i = 0; i < times; i++) {
            car.move(4);
        }

        assertThat(car.getPosition()).isEqualTo(previous + times);
    }

    @ParameterizedTest(name = "이동 숫자가 {0}이 들어오면 정지한다.")
    @ValueSource(ints = {-1, 0, 2, 3, 10})
    void 이동_숫자가_4미만_9초과면_전진(int number) {
        Car car = new Car("Stop");
        int previous = car.getPosition();

        car.move(number);

        assertThat(car.getPosition()).isEqualTo(previous);
    }
}
