package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    public static final int ONE_STEP = 1;

    @Test
    void moveForward() {
        //given
        String allen = "앨런";
        Name name = new Name(allen);
        Car car = new Car(name);

        int initState = car.getPosition();

        //when
        car.moveForward();

        //then
        assertThat(car.getPosition()).isEqualTo(initState + ONE_STEP);
    }
}