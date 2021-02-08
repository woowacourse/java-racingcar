package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.exception.InvalidNameLengthException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    public void 자동차_객체_생성_테스트() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @ParameterizedTest
    @ValueSource(strings = {"poooobi", ""})
    public void 이름_길이가_잘못된_경우_예외처리(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(InvalidNameLengthException.class);
    }
}
