package domain.car;

import domain.car.DriveStrategy;
import domain.car.RandomDriveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomDriveStrategyTest {

    @DisplayName("랜덤한 숫자가 0에서 3 사이의 숫자라면 자동차는 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void randomDriveStrategyStopTest(int number) {
        // given
        DriveStrategy driveStrategy = new RandomDriveStrategy(() -> number);
        CarPosition position = new CarPosition(0);

        // when
        position.move(driveStrategy.drive());

        // then
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @DisplayName("랜덤한 숫자가 4에서 9 사이의 숫자라면 자동차는 1만큼 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void randomDriveStrategyMoveTest(int number) {
        // given
        DriveStrategy driveStrategy = new RandomDriveStrategy(() -> number);
        CarPosition position = new CarPosition(0);

        // when
        position.move(driveStrategy.drive());

        // then
        assertThat(position.getPosition()).isEqualTo(1);
    }
}
