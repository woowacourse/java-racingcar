package racingcargame.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcargame.domain.car.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private static final String JAEJU = "재주";
    private static final String EMPTY_STRING = "";
    private static final String LENGTH_OVER_FIVE = "five!!";

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(JAEJU);
    }

    @Test
    @DisplayName("자동차는_이름을_입력받아_생성")
    void constructCarFromString() {
        Car car = new Car(JAEJU);
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("자동차_이름이_비어있으면_예외발생")
    void createCarFromEmptyStringThrowngExeption() {
        assertThatThrownBy(() -> new Car(EMPTY_STRING))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차_이름이_null이면_예외발생")
    void createCarFromnNullThrowingException() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차_이름이_5자_이상이면_예외발생")
    void createCarFromOverFiveLenghtTHorwinggExceptions() {
        assertThatThrownBy(() -> new Car(LENGTH_OVER_FIVE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의_위치가_입력된_값과_같은지_확인")
    void checkIfCarIsInSamePosition() {
        assertThat(car.isSamePositionWith(0)).isTrue();
        assertThat(car.isSamePositionWith(1)).isFalse();
    }

    @Test
    @DisplayName("자동차는_4이상의숫자를받으면_전진한다")
    void carMAddPositionWithNumberFourAbove() {
        car.move(4);
        assertThat(car.isSamePositionWith(1)).isTrue();
    }

    @Test
    @DisplayName("자동차는_3이하일경우_전진하지않는다")
    void carStopwithNumberTHreeBelow() {
        car.move(3);
        assertThat(car.isSamePositionWith(0)).isTrue();
    }
}
