package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RaceTest {
    public static final int START = 1;

    @ParameterizedTest
    @CsvSource(value = {"4,True", "3,false"})
    void moveForwardAccordingToCondition(int randomValue, boolean expected) {
        //given
        Race race = new Race();
        Car car = new Car("앨런");
        int initState = car.getPosition();
        //when
        race.moveAccordingToCondition(car, randomValue);
        //then
        assertThat(car.getPosition() == initState + START).isEqualTo(expected);
    }
}