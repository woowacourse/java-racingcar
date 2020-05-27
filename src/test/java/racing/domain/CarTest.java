package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차 이름이 5글자 이상인 경우 예외 발생")
    @Test
    public void constructWithNameLengthOverFive() {
        assertThatThrownBy(() -> {
            Car car = new Car("여섯글자이상");
        }).isInstanceOf(CarNameLengthOverFiveException.class)
                .hasMessage("자동차 이름은 5글이 이하만 가능합니다.");
    }

    @DisplayName("자동차 이름이 공백인 경우 예외 발생")
    @ParameterizedTest
    @EmptySource
    public void constructWithNameEmpty(String name) {
        assertThatThrownBy(() -> {
            Car car = new Car(name);
        }).isInstanceOf(CarNameEmptyException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @DisplayName("랜덤 숫자가 1~9 범위를 벗어나는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 10, 11, 100})
    public void moveWithInvalidAttributes(int number) {
        assertThatThrownBy(() -> {
            Car car = new Car("ysdog");
            car.move(number);
        }).isInstanceOf(OverRaceNumberRangeException.class)
                .hasMessage("1~9까지 숫자만 가능합니다.");
    }

    @DisplayName("랜덤 숫자가 4이상인 경우 position 증가")
    @Test
    public void moveWithValidAttributesOverFour() {
        Car car = new Car("ysdog");
        int positionBeforeMove = car.getPosition();

        car.move(4);

        assertThat(car.getPosition() - positionBeforeMove).isEqualTo(1);
    }

    @DisplayName("랜덤 숫자가 4미만인 경우 position 그대로")
    @Test
    public void moveWithValidAttributesUnderFour() {
        Car car = new Car("ysdog");
        int positionBeforeMove = car.getPosition();

        car.move(3);

        assertThat(car.getPosition() - positionBeforeMove).isEqualTo(0);
    }

    @DisplayName("포지션이 음수인 상태로 세팅되는 경우")
    @Test
    public void constructWithNegativePosition() {
        assertThatThrownBy(() -> {
            Car car = Car.of("ysdog", -1);
        }).isInstanceOf(NegativePositionException.class)
                .hasMessage("포지션은 음수가 될 수 없습니다.");
    }
}