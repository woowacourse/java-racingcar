package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarGroupTest {
    @Test
    @DisplayName("한 자동차 그룹에는 중복된 자동차가 존재할 수 없다.")
    void duplicatedCarInCarGroup() {
        Car duplicatedCar = new Car("moly");

        assertThatThrownBy(
                () -> new CarGroup(List.of(duplicatedCar, duplicatedCar)))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("가장 멀리 움직인 자동차가 우승한다.")
    void findWinnerTest() {
        Car moly = new Car("moly");
        Car pedro = new Car("pedro");
        CarGroup carGroup = new CarGroup(
                List.of(moly, pedro)
        );

        int moveNumber = 4;
        int notMoveNumber = 0;
        carGroup.race(List.of(moveNumber, notMoveNumber));

        assertThat(carGroup.findWinners()).isEqualTo(List.of(moly));
    }

    @Test
    @DisplayName("모든 자동차가 이동하지 않을 경우 우승자는 없다.")
    void drawTest() {
        Car pedro = new Car("pedro");
        Car moly = new Car("moly");
        CarGroup carGroup = new CarGroup(
                List.of(pedro, moly)
        );

        int notMoveNumber = 0;
        carGroup.race(List.of(notMoveNumber, notMoveNumber));

        assertThat(carGroup.findWinners()).isEmpty();
    }
}
