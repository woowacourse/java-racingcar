package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"4:2", "9:2", "0:1", "3:1"}, delimiter = ':')
    @DisplayName("차가 가지는 힘에 따른 이동, 정차를 테스트한다")
    void checkCarPositionByPower(int power, int position) {
        //given
        Car car1 = new Car(new Name("car1"));

        //when
        car1.move(power);

        //then
        assertThat(car1.getCurrentPosition()).isEqualTo(position);
    }
}