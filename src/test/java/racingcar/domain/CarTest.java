package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    public void 경주할_자동차_이름_입력_체크() {
        Car car = new Car("bmw");
        assertThat(car.getName()).isEqualTo("bmw");
    }

    @ParameterizedTest(name = "carName_1자리_이하이거나_5자리를_초과하면_RuntimeException이_발생(carName = {arguments})")
    @ValueSource(strings = {"", "abcdef"})
    public void carName_1자리_이하이거나_5자리를_초과하면_RuntimeException이_발생(String name) {
        assertThatThrownBy(() -> {
            Car car = new Car(name);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest(name = "carName_1자리이상_5자리이하(carName = {arguments})")
    @ValueSource(strings = {"a", "abcde"})
    public void carName_1자리이상_5자리이하(String name) {
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }
}
