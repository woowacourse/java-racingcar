package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("car가 4 이상의 숫자를 받을 때만 전진한다")
    void doesCarProceed() {
        Game game = new Game(0);
        Car car = new Car("hiro");
        for(int i = 0; i <= 3; i++) {
            assertFalse(game.checkMove(i));
        }
        for (int i = 4; i <= 9; i++) {
            assertTrue(game.checkMove(i));
        }
        assertThat(game.announceWinner().get("hiro")).isEqualTo(6);
    }
}