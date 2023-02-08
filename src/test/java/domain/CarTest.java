package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest(name = "이름이 {0}인 차는 생성 불가능")
    @ValueSource(strings = {"", "applej", "한글로여섯자", "***%^$"})
    void 길이가_1미만_5초과인_차는_예외_발생(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 1 ~ 5 글자여야 합니다");
    }

    @ParameterizedTest(name = "이름이 {0}인 차는 생성 가능")
    @ValueSource(strings = {"a", "apple", "한글다섯자", "&"})
    void 길이가_1미만_5초과인_차는_예외_미발생(String name) {
        assertThatNoException().isThrownBy(() -> new Car(name));
    }
}