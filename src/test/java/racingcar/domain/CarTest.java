package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.data.Car;
import racingcar.utils.exception.InvalidNameLengthException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    public void 자동차_객체_생성_테스트() {
        Car pobi = new Car("pobi", new RandomNumberRule());
        assertThat(pobi).isEqualTo(new Car("pobi", new RandomNumberRule()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"poooobi", ""})
    public void 이름_길이가_잘못된_경우_예외처리(String name) {
        assertThatThrownBy(() -> new Car(name, new RandomNumberRule()))
                .isInstanceOf(InvalidNameLengthException.class);
    }

    @Test
    public void 랜덤_숫자에_따른_전진_멈춤_테스트() {
        RandomNumberRuleStrategy forwardCase = () -> true;
        Car pobi = new Car("pobi", forwardCase);
        pobi.move();
        assertThat(pobi.getPosition()).isEqualTo(1);

        RandomNumberRuleStrategy stopCase = () -> false;
        Car brown = new Car("brown", stopCase);
        brown.move();
        assertThat(brown.getPosition()).isEqualTo(0);
    }
}
