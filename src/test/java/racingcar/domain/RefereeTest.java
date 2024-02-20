package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 1대라면 단독 우승자를 가려낸다.")
    void decideSingleWinner() {
        // given
        final Car car1 = new Car("pobi");
        final Car car2 = new Car("crong");
        final Car car3 = new Car("honux");

        car1.moveForward(new TestMoveForwardAccelerator());

        final Cars cars = new Cars(List.of(car1, car2, car3));
        final Referee referee = new Referee(cars.getCarsPosition());
        // when
        final List<String> actualWinners = referee.getWinners();
        final List<String> expectedWinners = List.of("pobi");
        //then
        assertAll(
                () -> assertThat(actualWinners).hasSize(expectedWinners.size()),
                () -> assertThat(actualWinners).containsExactlyElementsOf(expectedWinners)
        );
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 여러 대라면 공동 우승자를 가려낸다.")
    void decideJointWinners() {
        // given
        final Car car1 = new Car("pobi");
        final Car car2 = new Car("crong");
        final Car car3 = new Car("honux");

        final Cars cars = new Cars(List.of(car1, car2, car3));
        final Referee referee = new Referee(cars.getCarsPosition());
        // when
        final List<String> actualWinners = referee.getWinners();
        final List<String> expectedWinners = List.of("pobi", "crong", "honux");
        //then
        assertAll(
                () -> assertThat(actualWinners).hasSize(expectedWinners.size()),
                () -> assertThat(actualWinners).containsExactlyInAnyOrderElementsOf(expectedWinners)
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