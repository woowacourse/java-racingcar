package carracing.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @Test
    @DisplayName("랜덤값이 4 이상으로 주어질 경우 자동차의 position이 1 증가")
    void 랜덤값_4이상이면_전진() {
        //given
        Car car = new Car("pobi");
        Car stoppedCar = new Car("stop");
        //when
        car.move(() -> true);
        //then
        assertThat(car.compareTo(stoppedCar)).isNegative();
    }

    @Test
    @DisplayName("랜덤값이 4 미만으로 주어질 경우 자동차의 position 변화 없음")
    void 랜덤값_4미만이면_멈춤() {
        //given
        Car car = new Car("pobi");
        Car stoppedCar = new Car("stop");
        //when
        car.move(() -> false);
        //then
        assertThat(car.compareTo(stoppedCar)).isZero();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "0:true"}, delimiter = ':')
    @DisplayName("자동차의 위치가 같으면 true, 다르면 false를 반환")
    void 자동차_위치비교(int position, boolean expected) {
        //given
        Car car = new Car("pobi");
        //when
        //then
        assertThat(car.isEqualPosition(position)).isEqualTo(expected);
    }
}
