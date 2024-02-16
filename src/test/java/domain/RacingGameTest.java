package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("")
    void findWinners() {
        // given
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        // when
        carA.move();
        carB.move();
        carB.move();
        carC.move();
        carC.move();

        // then

    }
}
