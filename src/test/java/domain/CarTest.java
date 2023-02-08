package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class CarTest {
    @DisplayName("Car 객체 생성 시 이름이 5자 이하이면 정상적으로 생성된다.")
    @Test
    void test1() {
        assertThatNoException().isThrownBy(() -> new Car("자동차"));
    }

    @DisplayName("Car 객체 생성 시 이름이 5자 초과이면 예외를 발생시킨다.")
    @Test
    void test2() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("잘못된자동차이름"));
    }
}