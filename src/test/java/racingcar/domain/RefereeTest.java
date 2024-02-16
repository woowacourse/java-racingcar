package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    @DisplayName("단독 우승자 판독 테스트")
    void decideSingleWinner() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");

        car1.moveForward(new TestMoveForwardAccelerator());

        Cars cars = new Cars(List.of(car1, car2, car3), new CarAccelerator());

        // when
        List<String> actualWinners = Referee.getWinners(cars);
        List<String> expectedWinners = List.of("pobi");
        //then
        assertAll(
                () -> assertThat(actualWinners).hasSize(expectedWinners.size()),
                () -> assertThat(actualWinners).containsExactlyElementsOf(expectedWinners)
        );
    }

    @Test
    @DisplayName("공동 우승자 판독 테스트")
    void decideJointWinners() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");

        Cars cars = new Cars(List.of(car1, car2, car3), new CarAccelerator());

        // when
        List<String> actualWinners = Referee.getWinners(cars);
        List<String> expectedWinners = List.of("pobi", "crong", "honux");
        //then
        assertAll(
                () -> assertThat(actualWinners).hasSize(expectedWinners.size()),
                () -> assertThat(actualWinners).containsExactlyElementsOf(expectedWinners)
        );
    }

    static class TestMoveForwardAccelerator implements Accelerator {

        static final int MOVE = 4;
        @Override
        public int push() {
            return MOVE;
        }
    }
}