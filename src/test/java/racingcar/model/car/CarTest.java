package racingcar.model.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {
    @Test
    @DisplayName("자동차 객체 생성 성공")
    public void createCarTest() {
        // given
        String name = "test1";

        // when
        Car car = new Car(name);

        // then
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    @DisplayName("4 이상의 값이면 전진하고 아니면 정지한다")
    public void goOrStop(int random, int expected) {
        // given
        Car car = new Car("test");

        // when
        car.goOrStop(random);

        // then
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:false"}, delimiter = ':')
    @DisplayName("가장 멀리 간 위치인지 비교한다")
    public void compareToMaxPosition(int maxPosition, boolean expected) {
        // given
        Car car = new Car("foo");

        // then
        assertThat(car.isSameWithPosition(maxPosition)).isEqualTo(expected);
    }
}