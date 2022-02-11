package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private static final int ONE_STEP = 1;

    private RacingCar racingCar1;
    private RacingCar racingCar2;
    private RacingCar racingCar3;


    @BeforeEach
    public void setUp() {
        racingCar1 = RacingCar.generateRacingCar("pobi");
        racingCar2 = RacingCar.generateRacingCar("crong");
        racingCar3 = RacingCar.generateRacingCar("honux");
    }

    @Test
    @DisplayName("랜덤 값이 4이상이면 전진하는 기능 테스트")
    public void moveTest() {
        int beforePosition = racingCar1.getPosition();
        racingCar1.goOrStay(5);
        int afterPosition = racingCar1.getPosition();

        assertThat(beforePosition + ONE_STEP).isEqualTo(afterPosition);

    }

    @Test
    @DisplayName("위치가 제일 먼 자동차가 우승자인지 테스트")
    public void getWinners() {

        RacingGame racingGame = new RacingGame();
        List<RacingCar> racingCarList = new ArrayList<>(Arrays.asList(racingCar1, racingCar2, racingCar3));

        racingCar2.goOrStay(5);
        racingCar3.goOrStay(5);
        racingCar3.goOrStay(7);

        RacingCars racingCars = new RacingCars(racingCarList);

        ArrayList<RacingCar> winners = racingGame.getWinners(racingCars);

        assertThat(winners.get(0).getName()).isEqualTo(racingCar3.getName());
    }
}
