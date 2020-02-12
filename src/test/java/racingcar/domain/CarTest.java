package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"4,True", "3,false"})
    void 상황에_따른_전진(int randomValue, boolean expected) {
        //given
        Car car = new Car("앨런");
        int initState = car.getPosition();
        //when
        car.movePositionAccordingToCondition(randomValue);
        //then
        assertThat(car.getPosition() == initState + 1).isEqualTo(expected);
    }
}