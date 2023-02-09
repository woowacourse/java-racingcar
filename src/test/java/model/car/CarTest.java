package model.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car gitJjang;
    private Car irene;

    @BeforeEach
    void setUp() {
        gitJjang = new Car("깃짱");
        irene = new Car("이리내");
    }

    @Test
    void initialPositionTest() {
        Assertions.assertEquals(gitJjang.getPosition(), 0);
        Assertions.assertEquals(irene.getPosition(), 0);
    }

    @Test
    @DisplayName("자동차가 정상적으로 이동하는지 검사한다.")
    void carMoveTest() {
        moveEachCars();
        Assertions.assertEquals(gitJjang.getPosition(), 1);
        Assertions.assertEquals(irene.getPosition(), 0);
    }

    @Test
    @DisplayName("우승자인지 테스트한다.")
    void winnerTest() {
        moveEachCars();
        Assertions.assertTrue(gitJjang.isWinner(1));
        Assertions.assertFalse(irene.isWinner(1));
    }

    private void moveEachCars() {
        gitJjang.move(true);
        irene.move(false);
    }
}