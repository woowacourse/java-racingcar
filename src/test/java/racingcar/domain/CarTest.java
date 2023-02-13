package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    public static final Car ABEL = new Car("abel");
    public static final Car MERY = new Car("mery");
    public static final Car POBI = new Car("pobi");
    
    Car car;

    @BeforeEach
    void setup() {
        car = new Car("Mery");
    }

    @Test
    @DisplayName("정상적으로 차가 움직이는지 확인한다.")
    void move() {
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("차가 정지했을 때 position에 변화가 없는지 확인한다.")
    void moveFail() {
        car.move(() -> false);
        assertThat(car.getPosition()).isZero();
    }

    @ParameterizedTest(name = "name : {0}")
    @DisplayName("이름 길이가 1보다 작거나 5보다 큰 경우 예외를 발생시키는지 확인한다.")
    @NullAndEmptySource
    @ValueSource(strings = {"merrrrrrry", "pooooooobi", "pooooo"})
    void makeCars(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(name));
    }
    
    @ParameterizedTest(name = "carName : {0}")
    @NullAndEmptySource
    @DisplayName("자동차 이름 입력이 비어있는 경우 예외처리")
    void validateNullAndEmpty(String carName) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(carName));
    }
    
    @Test
    @DisplayName("자동차 이름의 길이 범위 초과 시 예외처리")
    void validateOutOfLength() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("bbbbbb"));
    }
    
    @ParameterizedTest(name = "carName : {0}")
    @ValueSource(strings = {"aa, b,cc", "aa,b ,cc"})
    @DisplayName("이름에는 공백을 입력 시 예외처리")
    void validateOutOfRange(String carName) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(carName));
    }
}