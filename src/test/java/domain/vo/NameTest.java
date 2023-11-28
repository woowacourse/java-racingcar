package domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import domain.core.Car;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest(name = "입력값={0}")
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void 이름은_1글자_이상_5글자_이하이다(String input) {
        // when
        Name name = new Name(input);
        Car car = new Car(name);

        // then
        assertThat(car.name().length())
                .isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(5);
    }

    @ParameterizedTest(name = "입력값={0}")
    @ValueSource(strings = {"", " ", "123456"})
    void 이름이_길이가_잘못되면_예외가_발생한다(String input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Name(input)
        );
    }
}
