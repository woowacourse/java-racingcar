package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class racingCarTest {
    @Test
    @DisplayName("게임 클래스를 검사")
    void gameTest() {
        Game game = new Game(5);
    }

    @Test
    @DisplayName("Car 클래스를 검사")
    void carTest() {
        Car car = new Car("pobi");
    }
}
