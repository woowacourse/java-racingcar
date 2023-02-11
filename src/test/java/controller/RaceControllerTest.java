package controller;

import domain.Car;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceControllerTest {

    private RaceController raceController;

    @BeforeEach
    void before() {
        raceController = new RaceController();
    }

    @DisplayName("숫자가 4보다 작으면 차가 움직이지 않는다")
    @Test
    void drive_or_not_not() {
        //given
        Car car = new Car("split", 0);
        //when
        raceController.driveOrNot(car, () -> 3);
        //then
        Assertions.assertThat(car.getDrivenDistance()).isEqualTo(0);
    }

    @DisplayName("숫자가 4이상이면 차가 움직인다")
    @Test
    void drive_or_not_drive() {
        //given
        Car car = new Car("split", 0);
        //when
        raceController.driveOrNot(car, () -> 4);
        //then
        Assertions.assertThat(car.getDrivenDistance()).isEqualTo(1);
    }

    @DisplayName("라운드가 한번도 진행되지 않은 경우 모두가 우승자이다.")
    @Test
    void get_winner_without_round() {
        //given
        final String carNames = "split,ash";
        raceController.joinAllParticipants(carNames);
        //when
        List<Car> winners = raceController.getWinners();
        //then
        Assertions.assertThat(winners.get(0).getName()).isEqualTo("split");
        Assertions.assertThat(winners.get(1).getName()).isEqualTo("ash");
    }
}
