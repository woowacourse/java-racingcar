package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    private static final int ONE_STEP = 1;
    private RacingCar racingCar1;
    @BeforeEach
    public void setUp() {
        racingCar1 = new RacingCar("pobi");
    }

    @Test
    @DisplayName("랜덤 값이 4이상이면 전진하는 기능 테스트")
    public void goOrStayTest() {
        int beforePosition = racingCar1.getPosition();
        racingCar1.goOrStay(5);
        int afterPosition = racingCar1.getPosition();

        assertThat(beforePosition + ONE_STEP).isEqualTo(afterPosition);

    }

    @Test
    @DisplayName("객체가 생성될 때 이름이 없는지 확인하는 기능 테스트")
    public void validateNameTest() {
        assertThatThrownBy(() -> new RacingCar("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("객체가 생성될 때 이름의 글자수가 5이하인지 확인하는 기능 테스트")
    public void validateNameTest2() {
        assertThatThrownBy(() -> new RacingCar("123456")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("객체가 생성될 때 이름이 null인지 확인하는 테스트")
    public void validateNAmeTest3() {
        assertThatThrownBy(() -> new RacingCar(null)).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("두 자동차의 위치가 같을때 true를 반환하는지 확인하는 테스트")
    public void isSamePositionTest_True() {
        RacingCar sourceCar = new RacingCar("pobi");
        RacingCar targetCar = new RacingCar("josh");

        assertThat(sourceCar.isSamePosition(targetCar)).isEqualTo(true);
    }

    @Test
    @DisplayName("두 자동차의 위치가 다를 때 false를 반환하는지 확인하는 테스트")
    public void isSamePositionTest_False() {
        RacingCar sourceCar = new RacingCar("pobi");
        RacingCar targetCar = new RacingCar("josh");

        sourceCar.goOrStay(5);

        assertThat(sourceCar.isSamePosition(targetCar)).isEqualTo(false);
    }

    @Test
    @DisplayName("두 자동차의 위치를 비교하고 더 큰 자동차 객체를 반환하는 기능 테스트")
    public void compareCarTest() {
        RacingCar sourceCar = new RacingCar("pobi");
        RacingCar targetCar = new RacingCar("josh");
        targetCar.goOrStay(5);
        targetCar.goOrStay(5);
        targetCar.goOrStay(5);

        assertThat(sourceCar.compareTo(targetCar)).isEqualTo(-3);
    }


}
