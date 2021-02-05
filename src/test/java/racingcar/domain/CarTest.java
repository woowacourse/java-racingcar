package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    public void 경주할_자동차_이름_입력_체크() {
        Car car = Car.of("bmw");
        assertThat(car.getName()).isEqualTo("bmw");
    }

    @ParameterizedTest(name = "양쪽끝 공백을 제거한 자동차 이름이 1자리 미만거나 5자리를 초과하면 RuntimeException이 발생(carName = {arguments})")
    @ValueSource(strings = {"", "abcdef",  "  "})
    public void 양쪽끝_공백을_제거한_자동차_이름이_1자리_미만이거나_5자리를_초과하면_RuntimeException이_발생(String name) {
        assertThatThrownBy(() -> {
            Car.of(name);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest(name = "양쪽끝 공백을 제거한 자동차 이름이 1자리이상 5자리이하(carName = {arguments})")
    @ValueSource(strings = {"a", "abcde", " abcde "})
    public void 양쪽끝_공백을_제거한_자동차_이름이_1자리이상_5자리이하(String name) {
        Car car = Car.of(name);
        assertThat(car.getName()).isEqualTo(name.trim());
    }

    @Test
    public void 자동차이름은_null이거나_빈문자일수_없다() {
        assertThatThrownBy(() -> {
            Car.of(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
